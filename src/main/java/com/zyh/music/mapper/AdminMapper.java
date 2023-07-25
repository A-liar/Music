package com.zyh.music.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyh.music.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

/**
 * @projectName: music
 * @package: com.zyh.music.mapper
 * @className: AdminMapper
 * @author: A_liar.
 * @date: 2023/6/26 19:35
 * @version: 1.0
 * @description: 管理员 mapper
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}
