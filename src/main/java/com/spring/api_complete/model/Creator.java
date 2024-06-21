package com.spring.api_complete.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "creator")
public class Creator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_creator")
    private Integer id;

    @Column(name = "name_creator", nullable = false)
    private String name;

    @Column(name = "lasname_creator", nullable = false)
    private String lastname;

    @Column(name = "dateborn_creator")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateBorn;

    public Creator() {}

    public Creator(String name, String lastname, Date dateBorn) {
        this.name = name;
        this.lastname = lastname;
        this.dateBorn = dateBorn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(Date dateBorn) {
        this.dateBorn = dateBorn;
    }
}
