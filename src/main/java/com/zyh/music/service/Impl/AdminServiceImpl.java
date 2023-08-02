package com.zyh.music.service.Impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyh.music.entity.Admin;
import com.zyh.music.mapper.AdminMapper;
import com.zyh.music.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * @projectName: music
 * @package: com.zyh.music.service.Impl
 * @className: AdminServiceImpl
 * @author: A_liar.
 * @date: 2023/6/26 19:58
 * @version: 1.0
 * @description: 管理员 service实现层
 */
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper=adminMapper;
    }

    /**
     * @param adminName
     * @param password
     * @return int
     * @author A_liar.
     * @date 2023/6/26 19:59
     * @description: 验证管理员密码是否正确
     */
    @Override
    public boolean verifyPassword(Admin admin) {
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("admin_name", admin.getAdminName())
                .eq("password", admin.getPassword());
        System.out.println("验证管理员密码是否正确："+admin);
        StpUtil.login(adminMapper.selectOne(queryWrapper).getId());
        return adminMapper.exists(queryWrapper);
    }

    /**
     * @param adminName
     * @return String
     * @author A_liar.
     * @date 2023/8/2 17:04
     * @description: 查找管理员头像
     */
    @Override
    public String getAdminAvatar(String adminName) {
        QueryWrapper<Admin> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("admin_name",adminName);
        System.out.println("查找管理员："+adminName+" 的头像");
        return adminMapper.selectOne(queryWrapper).getAvatar();
    }


}
