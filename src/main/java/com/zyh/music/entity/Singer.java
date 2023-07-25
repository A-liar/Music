package com.zyh.music.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @projectName: music
 * @package: com.zyh.music.entity
 * @className: Singer
 * @author: A_liar.
 * @date: 2023/6/29 15:06
 * @version: 1.0
 * @description: 注释
 */
@Data
@TableName("singer")
public class Singer implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String singerName;

    private Integer sex;

    private String singerImage;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    private String address;

    private String introduction;
}
