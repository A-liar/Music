package com.zyh.music.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @projectName: music
 * @package: com.zyh.music.entity
 * @className: Admin
 * @author: A_liar.
 * @date: 2023/6/26 19:33
 * @version: 1.0
 * @description: 管理员 bean
 */
@Data
@TableName("admin")
public class Admin implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String adminName;

    private String password;

    private String avatar;
}
