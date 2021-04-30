package com.yipeng.task.demo.controller;

import com.yipeng.task.demo.model.po.Students;
import com.yipeng.task.demo.model.po.Teachers;
import com.yipeng.task.demo.model.vo.TeachersAndStudentCountVo;
import com.yipeng.task.demo.model.vo.TeachersVo;
import com.yipeng.task.demo.service.StudentService;
import com.yipeng.task.demo.service.TeacherService;
import com.yipeng.task.demo.utils.RestResponse;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: yipeng
 * @Date: 2021/4/29 15:36
 */
@Slf4j
@RestController
@RequestMapping("/task")
public class TaskController {

    @Resource
    private StudentService studentService;

    @Resource
    private TeacherService teacherService;

    /**
     * 初始数据
     * 暂且执行一次，本例没有进行老师学生的去重。
     * 朋友们，可以想想两张表唯一索引的设计
     * @return
     */
    @GetMapping("/insertStudents")
    public RestResponse<Boolean> insertStudents() {
        Students studentZhang = new Students("男", "张三");
        Students studentLi = new Students("男", "李四");
        Students studentWang = new Students("女", "王二");
        Teachers teachersLi = new Teachers("李老师");
        Teachers teachersLiu = new Teachers("刘老师");
        Teachers teachersZhang = new Teachers("张老师");
        Teachers teachersZhao = new Teachers("赵老师");
        Teachers teachersWang = new Teachers("王老师");
        Teachers teachersFu = new Teachers("付老师");
        Set<Teachers> teachers = new HashSet<>();
        teachers.add(teachersLi);
        teachers.add(teachersLiu);
        teachers.add(teachersZhang);
        teachers.add(teachersZhao);
        teachers.add(teachersWang);
        teachers.add(teachersFu);
        studentZhang.setTeachers(teachers);
        studentLi.setTeachers(teachers);
        studentWang.setTeachers(teachers);
        List<Students> studentsList = new ArrayList<>();
        studentsList.add(studentZhang);
        studentsList.add(studentLi);
        studentsList.add(studentWang);
        teacherService.saveTeachers(new ArrayList<>(teachers));
        studentService.saveStudents(studentsList);
        return RestResponse.buildSuccess(Boolean.TRUE);
    }

    /**
     * 获取全部学生信息
     * @return
     */
    @GetMapping("/getStudentsInfo")
    public RestResponse<List<Students>> getStudentsInfo() {
        return RestResponse.buildSuccess(studentService.getStudents());
    }

    /**
     * 获取全部教师信息
     * @return
     */
    @GetMapping("/getTeachersInfo")
    public RestResponse<List<Teachers>> getTeachersInfo() {
        return RestResponse.buildSuccess(teacherService.getTeachers());
    }

    /**
     * 获取全部教师信息及学生数量
     * @return
     */
    @GetMapping("/getTeachers")
    public RestResponse<List<TeachersAndStudentCountVo>> getTeachersAndStudentsCount() {
        return RestResponse.buildSuccess(teacherService.getTeachersAndStudentsCount());
    }

    /**
     * 通过id获取老师姓名
     * @param id
     * @return
     */
    @GetMapping("/teachers/{id}")
    public RestResponse<TeachersVo> getTeachersById(@PathVariable Long id) {
        return RestResponse.buildSuccess(teacherService.getTeachersById(id));
    }

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    @DeleteMapping("/students/delete/{id}")
    public RestResponse<Boolean> deleteStudentsById(@PathVariable Long id) {
        studentService.deleteStudentsById(id);
        return RestResponse.buildSuccess(Boolean.TRUE);
    }

    /**
     * 删除教师信息
     * @param id
     * @return
     */
    @DeleteMapping("/teachers/delete/{id}")
    public RestResponse<Boolean> deleteTeachersById(@PathVariable Long id) {
        teacherService.deleteTeachersById(id);
        return RestResponse.buildSuccess(Boolean.TRUE);
    }

}
