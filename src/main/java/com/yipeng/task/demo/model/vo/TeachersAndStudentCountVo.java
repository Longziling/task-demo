package com.yipeng.task.demo.model.vo;

import lombok.Data;

/**
 * @Author: yipeng
 * @Date: 2021/4/29 20:17
 */
@Data
public class TeachersAndStudentCountVo {

    private Long id;

    private String tname;

    private Integer count;

    public TeachersAndStudentCountVo() {}

    public TeachersAndStudentCountVo(Long id, String tname, Integer count) {
        this.id = id;
        this.tname = tname;
        this.count = count;
    }

}
