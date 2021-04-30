package com.yipeng.task.demo;

import com.yipeng.task.demo.model.vo.TeachersVo;
import com.yipeng.task.demo.service.TeacherService;

import javax.annotation.Resource;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: yipeng
 * @Date: 2021/4/29 23:51
 */
@Slf4j
public class TaskTest extends TaskDemoApplicationTest {

    @Resource
    private TeacherService teacherService;

    @Test
    public void getTeachersAndStudentsCountOne() {
        teacherService.getTeachersAndStudentsCountOne();
    }

    @Test
    public void getTeachersById() {
        TeachersVo teachersVo = teacherService.getTeachersById(6L);
        log.info(teachersVo.toString());
    }



}
