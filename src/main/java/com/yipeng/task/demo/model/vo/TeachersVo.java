package com.yipeng.task.demo.model.vo;

import lombok.Data;

/**
 * @Author: yipeng
 * @Date: 2021/4/30 0:04
 */
@Data
public class TeachersVo {

    private String tname;

    /**
     * 必须存在该构造函数
     * @param tname
     */
    public TeachersVo(String tname) {
        this.tname = tname;
    }

}
