package com.zyh.music.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.zyh.music.Result.Result;
import com.zyh.music.Result.Status;
import com.zyh.music.entity.Admin;
import com.zyh.music.service.AdminService;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/admin")
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

    @PostMapping("/login")
    public Result<Admin> verifyPassword(Admin admin) {
        if (adminService.verifyPassword(admin)){
            StpUtil.login(adminService.getAdminId(admin));
            return Result.success(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), admin);
        }else {
            return Result.fail(Status.FAIL.getCode(), Status.FAIL.getMessage(), admin);
        }
    }

    /**
     *
     * @author A_liar.
     * @date 2023/8/2 16:53
     * @param adminName
     * @return Result<String>
     * @description:  查询管理员头像
    */

    @GetMapping("/getAdminAvatar")
    public Result<String> getAdminAvatar(String adminName) {
        if (StpUtil.isLogin()){
            return Result.success(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), adminService.getAdminAvatar(adminName));
        }else {
            System.out.println("查找管理员头像失败，"+adminName+"未登录");
            return Result.fail(Status.FAIL.getCode(), Status.FAIL.getMessage(), adminName+"头像查找失败");
        }
    }


    /**
     *
     * @author A_liar.
     * @date 2023/11/1 20:12
     * @param adminName
     * @param avatar
     * @return Result<String>
     * @description:  更新管理员头像
    */

    @PostMapping("/addOrUpdateAvatar")
    public Result<String> addOrUpdateAvatar(@RequestParam("adminName") String adminName,@RequestParam("avatar") String avatar) {
        System.out.println(adminName+"==========================>"+avatar);
        if (StpUtil.isLogin()) {
            return Result.success(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), adminService.addOrUpdateAvatar(adminName,avatar));
        }else {
            return Result.fail(Status.FAIL.getCode(),Status.FAIL.getMessage(), adminService.addOrUpdateAvatar(adminName,avatar));
        }
    }


    /**
     *
     * @author A_liar.
     * @date 2023/8/2 16:54

     * @return SaResult
     * @description:  验证管理员是否登录
    */

    public SaResult isLogin() {
        return SaResult.ok("是否登录："+ StpUtil.isLogin());
    }


}
