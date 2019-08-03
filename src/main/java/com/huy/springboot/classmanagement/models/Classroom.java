package com.huy.springboot.classmanagement.models;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="classroom")
public class Classroom {
    private int id;
    private int courseId;
    private int kidId;
    private int teacherId;
    private LocalDateTime time;
    private boolean status;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @NotNull
    @Column(name = "courseId")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @NotNull
    @Column(name = "kidId")
    public int getKidId() {
        return kidId;
    }

    public void setKidId(int kidId) {
        this.kidId = kidId;
    }

    @Basic
    @NotNull
    @Column(name = "teacherId")
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @NotNull
    @Column(name = "startTime")
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Basic
    @NotNull
    @Column(name = "status")
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Classroom(int id, int courseId, int kidId, int teacherId, LocalDateTime time, boolean status) {
        super();
        this.id = id;
        this.courseId = courseId;
        this.kidId = kidId;
        this.teacherId = teacherId;
        this.time = time;
        this.status = status;
    }

    public Classroom() {
        // TODO Auto-generated constructor stub
    }
}
