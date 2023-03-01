package com.starry_sky.yang.controller;

import com.starry_sky.yang.pojo.User;
import com.starry_sky.yang.service.UserService;
import com.starry_sky.yang.utils.VerifyCodeUtils;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/users")
public class userController {

    private UserService userService;

    @Autowired
    public userController(UserService userService){
        this.userService = userService;
    }
    /**
     * 生成验证码
     */
    @RequestMapping("/generatedImageCode")
    public void generatedImageCode(HttpSession session, HttpServletResponse response) throws IOException {
        //1、生成四位随机数
        String code = VerifyCodeUtils.generateVerifyCode(4);
        //2、保存到session作用域
        session.setAttribute("code",code);

        //3、通过随机数生成图片
        //4、通过response响应图片
        //5、设置响应类型
        response.setContentType("image/png");
        ServletOutputStream outputStream = response.getOutputStream();
        VerifyCodeUtils.outputImage(220,60,outputStream,code);
    }

    /**
     * 用户注册
     *
     * User 中的属性和提交表单的名字相同
     * String 后的形参和提交表单的名字相同
     */

    @RequestMapping("/register")
    public String register(User user, String code, HttpSession session){
        try{
            //通过session获取生成验证码并与用户输入验证码比对，判断验证码是否输入正确
            String code1 = session.getAttribute("code").toString();
 
            if (!code1.equalsIgnoreCase(code)) throw new RuntimeException("验证码输入错误！");
            //验证码输入正确，进行用户注册的业务
            userService.register(user);
        } catch (RuntimeException e){
            e.printStackTrace();
            return "redirect:/register";
        }

        return "redirect:/login";
    }

    /**
     * 用户登录
     */

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        try{
            //调用业务层方法
            User loginUser = userService.login(username, password);
            //保存用户信息
            session.setAttribute("loginUser",loginUser);
        } catch (Exception e){
            e.printStackTrace();
            //登录失败
            return "redirect:/login";
        }

        /**
         * 登录成功之后需要跳转到用户列表页面
         * 如果直接跳转到页面会导致没有数据，因为还没有查询数据库
         * 所以，应该先跳转到用户列表页面的控制器进行数据查询
         * 然后在有页面跳转的控制器，跳转到用户页面
         *
         * 总结：用户登录控制器--》用户列表控制器（查数据）--》用户列表页面
         */
        return "redirect:/employee/emplist";
    }

    /**
     * 安全退出
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        //销毁session
        session.invalidate();
        return "redirect:/login";
    }
}
