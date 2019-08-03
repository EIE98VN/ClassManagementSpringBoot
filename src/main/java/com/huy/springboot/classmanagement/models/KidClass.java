package com.huy.springboot.classmanagement.models;

public class KidClass {
    private String courseName;
    private String teacherName;
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getTeacherName() {
        return teacherName;
    }
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public KidClass(String courseName, String teacherName) {
        super();
        this.courseName = courseName;
        this.teacherName = teacherName;
    }
    
}
