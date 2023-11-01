package com.zyh.music.controller;

import com.zyh.music.Result.Result;
import com.zyh.music.Result.Status;
import com.zyh.music.entity.Singer;
import com.zyh.music.service.SingerService;
import com.zyh.music.utils.ImageNameUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Objects;

/**
 * @projectName: music
 * @package: com.zyh.music.controller
 * @className: SingerController
 * @author: A_liar.
 * @date: 2023/6/29 15:45
 * @version: 1.0
 * @description: 注释
 */
@RestController
@RequestMapping("/singer")
public class SingerController {

    private final SingerService singerService;

    SingerController(SingerService singerService){
        this.singerService=singerService;
    }

    /**
     *
     * @author A_liar.
     * @date 2023/6/29 16:11
     * @param singer
     * @return Result<Singer>
     * @description:  添加歌手
    */

    @PostMapping("/addSinger")
    public Result<Singer> addSinger(Singer singer) {
        boolean flag=singerService.addSinger(singer);
        if (flag) {
            return Result.success(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), singer);
        }else {
            return Result.fail(Status.FAIL.getCode(), Status.FAIL.getMessage(), singer);
        }
    }

    /**
     *
     * @author A_liar.
     * @date 2023/6/29 16:30
     * @param singer
     * @return Result<Singer>
     * @description:   删除歌手
    */

    @PostMapping("/deleteSinger")
    public Result<Singer> deleteSinger(Singer singer) {
        boolean flag=singerService.deleteSinger(singer);
        if (flag) {
            return Result.success(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), singer);
        }else {
            return Result.fail(Status.FAIL.getCode(), Status.FAIL.getMessage(), singer);
        }
    }

    /**
     *
     * @author A_liar.
     * @date 2023/6/29 16:51
     * @param id
     * @return Result<Singer>
     * @description:  根据主键查询歌手
    */

    @GetMapping("/selectByPrimaryKey")
    public Result<Singer> selectByPrimaryKey(Integer id) {
        return Result.success(Status.SUCCESS.getCode(),Status.SUCCESS.getMessage(), singerService.selectByPrimary(id));
    }

    /**
     *
     * @author A_liar.
     * @date 2023/6/29 17:16

     * @return Result<Singer>
     * @description:  查询所有歌手
    */

    @GetMapping("/selectAllSinger")
    public Result<List<Singer>> selectAllSinger(){
        return Result.success(Status.SUCCESS.getCode(),Status.SUCCESS.getMessage(), singerService.selectAllSinger());
    }

    /**
     *
     * @author A_liar.
     * @date 2023/6/29 17:23
     * @param singerName
     * @return Result<List<Singer>>
     * @description:  根据歌手姓名模糊查询
    */

    @GetMapping("/selectSingerByName")
    public Result<List<Singer>> selectSingerByName(String singerName) {
        return Result.success(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), singerService.selectSingerByName(singerName));
    }

    /**
     *
     * @author A_liar.
     * @date 2023/6/29 17:28
     * @param sex
     * @return Result<List<Singer>>
     * @description:  根据性别查询歌手
    */

    @GetMapping("/selectSingerBySex")
    public Result<List<Singer>> selectSingerBySex(Integer sex) {
        return Result.success(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), singerService.selectSingerBySex(sex));
    }


    /**
     *
     * @author A_liar.
     * @date 2023/6/30 10:55
     * @param multipartFile
     * @return Result<String>
     * @description:  图片上传保存
    */

    @PostMapping("/addSingerImage")
    public Result<String> addSingerImage(@RequestParam("file") MultipartFile multipartFile) {
//        String folder="D:/File/Photos/MusicImage";
        String folder=System.getProperty("user.dir")+System.getProperty("file.separator")+"image"+System.getProperty("file.separator")+"singerImage"+System.getProperty("file.separator");
        File imageFolder=new File(folder);
        File file=new File(imageFolder, ImageNameUtil.getImageName()+ Objects.requireNonNull(multipartFile.getOriginalFilename()).substring(multipartFile.getOriginalFilename().length()-4));
        if (!file.getParentFile().exists()) {
            System.out.println("创建目录："+file.getParentFile());
            file.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(file);
            String imageUrl = "http://localhost:8848/singer/imageFile/" + file.getName();
            System.out.println("写入磁盘之后返回图片Url："+imageUrl);
            return Result.success(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), imageUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(Status.FAIL.getCode(), Status.FAIL.getMessage(), "图片上传、获取错误："+(multipartFile));
        }
    }

    /**
     *
     * @author A_liar.
     * @date 2023/7/25 21:58
     * @param imgName
     * @return Result<String>
     * @description:  删除歌手图片
    */

    @PostMapping("/deleteSingerImg")
    public Result<String> deleteSingerImg(String imgName) {
        String folder=System.getProperty("user.dir")+System.getProperty("file.separator")+"image"+System.getProperty("file.separator")+"singerImage"+System.getProperty("file.separator")+imgName.substring(38);
        File file=new File(folder);
        boolean deleteImage= file.delete();
        if (deleteImage) {
            System.out.println("删除图片："+imgName);
            return Result.success(Status.SUCCESS.getCode(), Status.SUCCESS.getMessage(), imgName);
        }else {
            System.out.println("删除图片失败："+imgName);
            return Result.fail(Status.FAIL.getCode(), Status.FAIL.getMessage(), imgName);
        }
    }
}
