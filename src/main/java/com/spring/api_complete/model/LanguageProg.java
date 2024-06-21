package com.spring.api_complete.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "language_prog")
public class LanguageProg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_language")
    private Integer id;

    @Column(name = "name_language", nullable = false)
    private String name;

    @Column(name = "datecration_language")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date_creation;

    @JoinColumn(name = "creator_language", nullable = false)
    @ManyToOne
    private Creator creator;

    public LanguageProg() {}

    public LanguageProg(String name, Date date_creation, Creator creator) {
        this.name = name;
        this.date_creation = date_creation;
        this.creator = creator;
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

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }
}
