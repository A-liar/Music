package com.zyh.music.service;

import com.zyh.music.entity.Singer;

import java.util.List;

/**
 * @projectName: music
 * @package: com.zyh.music.service
 * @className: SingerService
 * @author: A_liar.
 * @date: 2023/6/29 15:42
 * @version: 1.0
 * @description: 注释
 */
public interface SingerService {

    /** 
     * 
     * @author A_liar.
     * @date 2023/6/29 15:55
     * @param singer 
     * @return boolean  
     * @description:  添加歌手
    */
    
    boolean addSinger(Singer singer);

    /**
     *
     * @author A_liar.
     * @date 2023/6/29 16:16
     * @param singer
     * @return boolean
     * @description:  修改歌手信息
    */

    boolean updateSinger(Singer singer);

    /**
     *
     * @author A_liar.
     * @date 2023/6/29 16:32
     * @param singer
     * @return boolean
     * @description:  删除歌手
    */

    boolean deleteSinger(Singer singer);

    /**
     *
     * @author A_liar.
     * @date 2023/6/29 16:48
     * @param id
     * @return Singer
     * @description:  根据主键查询对象
    */

    Singer selectByPrimary(Integer id);

    /**
     *
     * @author A_liar.
     * @date 2023/6/29 17:17

     * @return List<Singer>
     * @description:  查询所有歌手
    */

    List<Singer> selectAllSinger();

    /**
     *
     * @author A_liar.
     * @date 2023/6/29 17:23
     * @param singerName
     * @return List<Singer>
     * @description:  根据歌手姓名查询模糊查询
    */

    List<Singer> selectSingerByName(String singerName);

    /**
     *
     * @author A_liar.
     * @date 2023/6/29 17:29
     * @param sex
     * @return List<Singer>
     * @description:  根据性别查询歌手
    */

    List<Singer> selectSingerBySex(Integer sex);
}
