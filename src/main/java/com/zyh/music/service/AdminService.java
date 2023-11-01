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


    /**
     *
     * @author A_liar.
     * @date 2023/8/2 17:04
     * @param adminName
     * @return String
     * @description:  查找管理员头像
    */

    public String getAdminAvatar(String adminName);


    /**
     *
     * @author A_liar.
     * @date 2023/10/31 20:33
     * @param admin
     * @return Integer
     * @description:  查找管理员ID
    */

    public Integer getAdminId(Admin admin);


    /**
     *
     * @author A_liar.
     * @date 2023/11/1 20:13
     * @param adminName
     * @param avatar
     * @return String
     * @description:  更新管理员头像
    */

    String  addOrUpdateAvatar(String adminName, String avatar);
}
