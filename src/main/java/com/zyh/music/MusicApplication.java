package com.zyh.music;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zyh.music.mapper")
public class MusicApplication {
    public static void main(String[] args) {
        SpringApplication.run(MusicApplication.class, args);
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@2");
//        System.out.println("启动成功，Sa-Token 配置如下：" + SaManager.getConfig());
    }
}
