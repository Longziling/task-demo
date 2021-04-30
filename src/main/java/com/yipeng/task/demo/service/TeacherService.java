package com.yipeng.task.demo.service;

import com.yipeng.task.demo.dao.TeachersDao;
import com.yipeng.task.demo.model.po.Teachers;
import com.yipeng.task.demo.model.vo.TeachersImpl;
import com.yipeng.task.demo.model.vo.TeachersAndStudentCountVo;
import com.yipeng.task.demo.model.vo.TeachersVo;
import com.yipeng.task.demo.utils.PoVoUtils;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * @Author: yipeng
 * @Date: 2021/4/29 15:33
 */
@Service
public class TeacherService {

    @Resource
    private TeachersDao teachersDao;

    public List<Teachers> getTeachers() {
        return (List<Teachers>) teachersDao.findAll();
    }

    public void saveTeachers(List<Teachers> teachersList) {
        teachersDao.saveAll(teachersList);
    }

    public void deleteTeachersById(Long id) {
        teachersDao.deleteById(id);
    }

    public TeachersVo getTeachersById(Long id) {
        TeachersVo teachersVo = teachersDao.getTeachersById(id);
        return teachersVo;
    }

    /**
     * 方法一： JPA自动获取（一般情况推荐）
     * @return
     */
    public List<TeachersAndStudentCountVo> getTeachersAndStudentsCount() {
        List<Teachers> teachersList = teachersDao.findAll();
        return PoVoUtils.transferList(teachersList, TeachersAndStudentCountVo.class, (p, v) -> {
            v.setCount(p.getStudents() == null ? 0 : p.getStudents().size());
        });
    }

    /**
     * 方法二：原生SQL 接口获取（超复杂情况推荐）
     */
    public List<TeachersAndStudentCountVo> getTeachersAndStudentsCountOne() {
        List<TeachersImpl> teachersList = teachersDao.getTeachersAndStudentsCountOne();
        return PoVoUtils.transferList(teachersList, TeachersAndStudentCountVo.class, (p, v) -> {
            v.setId(p.getId());
            v.setTname(p.getTname());
            v.setCount(p.getCount());
        });
    }

    /**
     * 方法三：原生SQL Object获取（了解，不推荐）
     */
    public List<TeachersAndStudentCountVo> getTeachersAndStudentsCountTwo() {
        List<Object[]> teachersList = teachersDao.getTeachersAndStudentsCountTwo();
        return PoVoUtils.transferList(teachersList, TeachersAndStudentCountVo.class, (p, v) -> {
            v.setId(Long.parseLong(p[0].toString()));
            v.setTname(p[1].toString());
            v.setCount(Integer.parseInt(p[2].toString()));
        });
    }

}