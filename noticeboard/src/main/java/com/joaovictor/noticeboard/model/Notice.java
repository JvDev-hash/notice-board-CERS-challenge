package com.joaovictor.noticeboard.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Notice implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;


    @Column(nullable = false)
    private String title;


    @Column(nullable = false)
    private String description;


    @Column(nullable = false)
    private Date publishDate;


    @Column(nullable = true)
    private Date viewDate;

    @Column(nullable = false)
    private String viewFlag;


    public Notice(){

    }

    public Notice(String title, String description, Date publishDate, Date viewDate){

        this.title = title;
        this. description = description;
        this.publishDate = publishDate;
        this.viewDate = viewDate;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishDate() {
        return this.publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getViewDate() {
        return this.viewDate;
    }

    public void setViewDate(Date viewDate) {
        this.viewDate = viewDate;
    }

    public String getViewFlag() {
        return this.viewFlag;
    }

    public void setViewFlag(String viewFlag) {
        this.viewFlag = viewFlag;
    }


    @Override
    public String toString() {
        return "Notice [id=" + id + ", title=" + title + ", description=" + description + ", publishDate=" + publishDate +
                ", viewDate=" + viewDate + "]";
    }
}
