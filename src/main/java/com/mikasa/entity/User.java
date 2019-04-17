package com.mikasa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName User
 * @description
 * @author: tianluhua
 * @date 2019/4/17 16:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {


    /**
     * 名字
     */
    private String name;


    /**
     * 地址
     */
    private String address;


    /**
     * 国家
     */
    private String country;


    /**
     * 分值
     */
    private Integer scode;

}
