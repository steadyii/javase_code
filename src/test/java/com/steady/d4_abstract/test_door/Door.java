package com.steady.d4_abstract.test_door;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 定义抽象类门,门有不同的功能,将功能提取为接口,方便维护
 * <p>
 * 抽象类抽取实体类的共有属性,简化开发,单继承确保单一
 * 接口定义少数供能,根据需求实现,可以多实现
 */
@AllArgsConstructor
@Getter
@ToString
public abstract class Door {
    private int height;
    private int weight;
    private String name;

    public abstract void open();
    public abstract void close();
}
