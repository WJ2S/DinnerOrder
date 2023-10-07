package com.uts.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Author: Shaobo
 * Date: 2023/10/6
 * Describe:
 */

@Data
@AllArgsConstructor
@TableName("users")
public class User implements Serializable {
    @TableId("id")
    private int id;
    private String username;
    private String email;
    private String password;
}
