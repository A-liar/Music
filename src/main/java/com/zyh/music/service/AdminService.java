package com.zyh.music.service;

import com.zyh.music.entity.Admin;

public interface AdminService {
    /**
     *
     * @author A_liar.
     * @date 2023/6/26 19:59
     * @param adminName
     * @param password
     * @return int
     * @description:  验证管理员密码是否正确
    */

    public boolean verifyPassword(Admin admin);
}
