package com.example.kryo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description: 模块功能描述
 * <p>
 * User: luo0412
 * Date: 2020-08-28 12:37
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private int age;


}
