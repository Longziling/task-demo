package com.yipeng.task.demo.model.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: yipeng
 * @Date: 2021/4/29 15:30
 */
@Data
@Entity
@Table(name = "students")
@NoArgsConstructor
public class Students extends BasePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String gender;

    @JsonIgnoreProperties(value = { "students" })
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="teachers_students" , joinColumns={@JoinColumn(name="sid", referencedColumnName = "id")}, inverseJoinColumns={@JoinColumn(name="tid", referencedColumnName = "id")})
    private Set<Teachers> teachers;

    // 仅作测试用途
    public Students(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

}
