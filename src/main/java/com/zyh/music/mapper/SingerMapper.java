package com.zyh.music.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyh.music.entity.Singer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SingerMapper extends BaseMapper<Singer> {
//    /**
//     *
//     * @author A_liar.
//     * @date 2023/6/29 15:12
//     * @param singer
//     * @return int
//     * @description:  添加一个歌手
//    */
//
//    public int addSinger(Singer singer);
//
//    /**
//     *
//     * @author A_liar.
//     * @date 2023/6/29 15:12
//     * @param singer
//     * @return int
//     * @description:  更新歌手信息
//    */
//
//    public int updateSinger(Singer singer);
//
//    /**
//     *
//     * @author A_liar.
//     * @date 2023/6/29 15:30
//     * @param singer
//     * @return int
//     * @description:  删除歌手
//    */
//
//    public int deleteSinger(Singer singer);
//
//    /**
//     *
//     * @author A_liar.
//     * @date 2023/6/29 15:32
//     * @param id
//     * @return Singer
//     * @description:  根据主键查询
//    */
//
//    public Singer selectByPrimaryKey(Integer id);
//
//    /**
//     *
//     * @author A_liar.
//     * @date 2023/6/29 15:33
//          * @return List<Singer>
//     * @description:  查询所有歌手
//    */
//
//    public List<Singer> allSinger();
//
//    /**
//     *
//     * @author A_liar.
//     * @date 2023/6/29 15:35
//     * @param name
//     * @return List<Singer>
//     * @description:  根据名字模糊查询
//    */
//
//    public List<Singer> singerOfName(String name);
}
