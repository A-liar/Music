package com.zyh.music.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.zyh.music.entity.Singer;
import com.zyh.music.mapper.SingerMapper;
import com.zyh.music.service.SingerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName: music
 * @package: com.zyh.music.service.Impl
 * @className: SingerServiceImpl
 * @author: A_liar.
 * @date: 2023/6/29 15:42
 * @version: 1.0
 * @description: 注释
 */
@Service
public class SingerServiceImpl implements SingerService {

    private SingerMapper singerMapper;

    SingerServiceImpl(SingerMapper singerMapper) {
        this.singerMapper=singerMapper;
    }

    /**
     * @param singer
     * @return boolean
     * @author A_liar.
     * @date 2023/6/29 15:55
     * @description: 添加歌手
     */
    @Override
    public boolean addSinger(Singer singer) {
        System.out.println("添加歌手："+singer);
        return singerMapper.insert(singer)>0;
    }

    /**
     * @param singer
     * @return boolean
     * @author A_liar.
     * @date 2023/6/29 16:16
     * @description: 修改歌手信息
     */
    @Override
    public boolean updateSinger(Singer singer) {
        UpdateWrapper<Singer> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("id",singer.getId())
                .set("singer_name",singer.getSingerName())
                .set("sex",singer.getSex())
                .set("singer_image",singer.getSingerImage())
                .set("birthday",singer.getBirthday())
                .set("address",singer.getAddress())
                .set("introduction",singer.getIntroduction());
        System.out.println("更新歌手信息："+singer);
        return singerMapper.update(null,updateWrapper)>0;
    }

    /**
     * @param singer
     * @return boolean
     * @author A_liar.
     * @date 2023/6/29 16:32
     * @description: 删除歌手
     */
    @Override
    public boolean deleteSinger(Singer singer) {
        System.out.println("删除歌手："+singer);
        return singerMapper.deleteById(singer)>0;
    }

    /**
     * @param id
     * @return Singer
     * @author A_liar.
     * @date 2023/6/29 16:48
     * @description: 根据主键查询对象
     */
    @Override
    public Singer selectByPrimary(Integer id) {
        System.out.println("根据主键查询歌手："+id);
        return singerMapper.selectById(id);
    }

    /**
     *
     * @author A_liar.
     * @date 2023/6/29 17:17

     * @return List<Singer>
     * @description:  查询所有歌手
     */
    @Override
    public List<Singer> selectAllSinger() {
        System.out.println("查询所有歌手。");
        return singerMapper.selectList(null);
    }

    /**
     * @param name
     * @return List<Singer>
     * @author A_liar.
     * @date 2023/6/29 17:23
     * @description: 根据歌手姓名查询模糊查询
     */
    @Override
    public List<Singer> selectSingerByName(String singerName) {
        System.out.println("根据歌手姓名模糊查询歌手："+singerName);
        QueryWrapper<Singer> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("singer_name",singerName);
        return singerMapper.selectList(queryWrapper);
    }

    /**
     * @param sex
     * @return List<Singer>
     * @author A_liar.
     * @date 2023/6/29 17:29
     * @description: 根据性别查询歌手
     */
    @Override
    public List<Singer> selectSingerBySex(Integer sex) {
        QueryWrapper<Singer> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("sex",sex);
        System.out.println("根据性别查询歌手："+sex);
        return singerMapper.selectList(queryWrapper);
    }
}
