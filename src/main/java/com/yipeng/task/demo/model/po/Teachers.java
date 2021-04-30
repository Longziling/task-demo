package com.yipeng.task.demo.model.po;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author: yipeng
 * @Date: 2021/4/29 15:31
 */

@Data
@Entity
@Table(name = "teachers")
@EqualsAndHashCode(exclude = {"students"}, callSuper = false)
@NoArgsConstructor
public class Teachers extends BasePo implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=8)
    private Long id;

    private String tname;

    @JsonIgnoreProperties(value = { "teachers" })
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="teachers_students" , joinColumns={@JoinColumn(name="tid", referencedColumnName = "id")}, inverseJoinColumns={@JoinColumn(name="sid", referencedColumnName = "id")})
    private Set<Students> students;

    // 仅作测试用途
    public Teachers(String tname) {
        this.tname = tname;
    }

}
