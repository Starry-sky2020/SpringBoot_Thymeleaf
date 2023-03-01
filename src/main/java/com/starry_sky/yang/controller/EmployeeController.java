package com.starry_sky.yang.controller;

import com.starry_sky.yang.pojo.Employee;
import com.starry_sky.yang.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    /**
     * 图片保存路径
     */
    @Value("${photo.file.dir}")
    private String realpath;

    @Autowired
    private EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    /**
     * 查询员工列表
     * @param model
     * @return
     */
    @RequestMapping("/emplist")
    public String empList(Model model){

        List<Employee> employeeList = employeeService.employeeList();
        model.addAttribute("employeeList",employeeList);

        return "emplist";
    }

    /**
     * 添加员工
     * 保存员工数据
     * 文件上传；
     *  1.表单必须以post方式提交
     *  2.表单的enctype属性必须为 multipart、form-data
     * @param employee
     * @param img
     * @return
     */
    @RequestMapping("/save")
    public String save(Employee employee, MultipartFile img) throws IOException {

        String originalFilename = img.getOriginalFilename();
        //1.处理头像的上传&更改文件名
        String newFileName = uploadPhoto(img, originalFilename);

        //2.保存员工信息
        employee.setPhoto(newFileName);
        employeeService.save(employee);

        return "redirect:/employee/emplist";
    }

    /**
     * 实现文件的上传功能
     * @param img
     * @param originalFilename
     * @return
     * @throws IOException
     */
    private String uploadPhoto(MultipartFile img, String originalFilename) throws IOException {
        String fileNamePrefix = new SimpleDateFormat("yyyyMMddHHmmssSSSS").format(new Date());
        String fileNameSuffix = originalFilename.substring(originalFilename.lastIndexOf('.'));
        String newFileName = fileNamePrefix + fileNameSuffix;
        img.transferTo(new File(realpath, newFileName));
        return newFileName;
    }

    /**
     * 根据员工id查询员工信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/detail")
    public String detail(Integer id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee",employee);

        return "updateEmp";
    }

    /**
     *更新员工信息
     * @param employee
     * @param img
     * @return
     * @throws IOException
     */
    @RequestMapping("/update")
    public String update(Employee employee, MultipartFile img) throws IOException {
        //1.判断是否更新图像
        boolean imgEmpty = img.isEmpty();
        System.out.println("-----------------------------------------");
        System.out.println("hh:"+employee);
        //图像不为空
        if (!imgEmpty){
            //2.删除老的头像
            String photo = employeeService.findById(employee.getId()).getPhoto();
            File file = new File(realpath, photo);
            if (file.exists()) file.delete();
            //3.处理新头像
            String originalFilename = img.getOriginalFilename();
            String photo1 = uploadPhoto(img, originalFilename);
            //4.上传新头像
            employee.setPhoto(photo1);
        }
        //5.更新员工信息
        employeeService.update(employee);

        return "redirect:/employee/emplist";
    }

    /**
     * 删除员工信息
     * 注意头像的删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public String delete(Integer id){
        //删除头像
        String photo = employeeService.findById(id).getPhoto();
        File file = new File(realpath, photo);
        if (file.exists()) file.delete();
        //删除数据
        employeeService.delete(id);

        return "redirect:/employee/emplist";
    }

}
