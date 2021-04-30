package com.yipeng.task.demo.service;

        import com.yipeng.task.demo.dao.StudentsDao;
        import com.yipeng.task.demo.model.po.Students;

        import java.util.List;
        import javax.annotation.Resource;

        import org.springframework.stereotype.Service;

/**
 * @Author: yipeng
 * @Date: 2021/4/29 15:33
 */
@Service
public class StudentService {

    @Resource
    private StudentsDao studentsDao;

    public List<Students> getStudents() {
        return (List<Students>) studentsDao.findAll();
    }

    public void saveStudents(List<Students> studentsList) {
        studentsDao.saveAll(studentsList);
    }

    public void deleteStudentsById(Long id) {
        studentsDao.deleteById(id);
    }


}