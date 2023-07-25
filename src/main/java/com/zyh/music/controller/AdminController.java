package com.zyh.music.controller;

import com.zyh.music.Result.Result;
import com.zyh.music.Result.Status;
import com.zyh.music.entity.Admin;
import com.zyh.music.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: music
 * @package: com.zyh.music.controller
 * @className: AdminController
 * @author: A_liar.
 * @date: 2023/6/26 20:05
 * @version: 1.0
 * @description: 管理员 controller
 */
@RestController
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService=adminService;
    }

    /**
     *
     * @author A_liar.
     * @date 2023/6/29 16:13
     * @param admin
     * @return Result<Admin>
     * @description:  管理员登录
    */

    @RequestMapping("/admin/login")
    public Result<Admin> verifyPassword(Admin admin) {
        if (adminService.verifyPassword(admin)){
            return Result.success(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), admin);
        }else {
            return Result.fail(Status.FAIL.getCode(), Status.FAIL.getMessage(), admin);
        }
    }

    @RequestMapping("/admin/getAvatar")
    public Result<String> getAvatar(String adminName) {
//        System.out.println("查找管理员："+adminName+"的头像");
        return Result.success(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), "http://localhost:8848/singer/imageFile/image.jpg");
    }

}
