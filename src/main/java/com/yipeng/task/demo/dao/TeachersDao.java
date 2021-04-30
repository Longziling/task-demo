package com.yipeng.task.demo.dao;

import com.yipeng.task.demo.model.po.Teachers;
import com.yipeng.task.demo.model.vo.TeachersImpl;
import com.yipeng.task.demo.model.vo.TeachersVo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

/**
 * @Author: yipeng
 * @Date: 2021/4/29 15:35
 */
public interface TeachersDao extends BaseDao<Teachers, Long> {

    List<Teachers> findAll();

    /**
     * 接口获取类
     * @return
     */
    @Query(nativeQuery = true, value = "select m.id as id, m.tname as tname, m.count as count from (select t.id, t.tname, (select count(ts.sid) from teachers_students ts where ts.tid=t.id) as count from teachers t) m where m.count > 0;")
    List<TeachersImpl> getTeachersAndStudentsCountOne();

    /**
     * 下面这两种格式，返回的是如下的数据
     * [
     *   1,
     *   "李老师",
     *   3
     * ]
     */
    @Query(nativeQuery = true, value = "select m.id, m.tname, m.count from (select t.id, t.tname, (select count(ts.sid) from teachers_students ts where ts.tid=t.id) as count from teachers t) m where m.count > 0;")
    List<Object[]> getTeachersAndStudentsCountTwo();

    /**
     * 此时记得
     * 不要添加 nativeQuery = true
     * 末尾不要写";"
     * @param id
     * @return
     */
    @Query(value = "select new com.yipeng.task.demo.model.vo.TeachersVo(tname) from Teachers where id =?1")
    TeachersVo getTeachersById(Long id);

}
