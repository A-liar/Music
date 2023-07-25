package com.zyh.music.Result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @projectName: music
 * @package: com.zyh.music.Result
 * @className: Result
 * @author: A_liar.
 * @date: 2023/6/26 20:21
 * @version: 1.0
 * @description: Result 返回结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    /**
     * @param status
     * @param message
     * @param data
     * @return Result<T>
     * @author A_liar.
     * @date 2023/6/27 18:25
     * @description: 成功---有成功状态码，消息，数据
     */

    public static <T> Result<T> success(Integer status, String message, T data) {
        return new Result<T>(status, message, data);
    }

    /**
     * @param status
     * @param message
     * @param data
     * @return Result<T>
     * @author A_liar.
     * @date 2023/6/27 18:37
     * @description: 失败---有失败状态码，消息，数据
     */

    public static <T> Result<T> fail(Integer status, String message, T data) {
        return new Result<T>(status, message, data);
    }


}
