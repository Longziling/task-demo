package com.yipeng.task.demo.model.vo;

/**
 * @Author: yipeng
 * @Date: 2021/4/29 23:46
 */
public interface  TeachersImpl {

    Long getId();

    String getTname();

    Integer getCount();

    default String toStringInfo() {
        return "id=" + getId() + "; tname=" + getTname() + "; count=" + getCount();
    }

}
