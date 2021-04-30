package com.yipeng.task.demo.dao;

import com.yipeng.task.demo.model.po.BasePo;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Author: yipeng
 * @Date: 2021/4/29 15:34
 */
@NoRepositoryBean
public interface BaseDao<T extends BasePo, IDT> extends PagingAndSortingRepository<T, IDT>, JpaSpecificationExecutor {

}
