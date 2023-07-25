package com.zyh.music;

import com.zyh.music.entity.Admin;
import com.zyh.music.mapper.AdminMapper;
import com.zyh.music.mapper.SingerMapper;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MusicApplicationTests {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private SingerMapper singerMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSelect() {
        System.out.println("-----selectAll method test-----");
        List<Admin> adminList=adminMapper.selectList(null);
        Assert.assertEquals(5,adminList.size());
        adminList.forEach(System.out::println);
    }

    @Test
    public void testTime() throws ParseException {
        System.out.println("-----time method test-----");
//        Date date = new Date();
//        System.out.println("this is date :" + date);
//        Singer singer=new Singer();
//        singer.setBirthday(date);
//        singerMapper.insert()

        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
//        dNow=ft.parse("Thu Jun 15 00:00:00 CST 2023");
        System.out.println("当前时间为: " + ft.format(dNow));
    }

}
