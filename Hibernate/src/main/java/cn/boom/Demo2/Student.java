package cn.boom.Demo2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {
    private int s_id;
    private String s_code;
    private String s_name;
    private String s_password;

    private Set<Course> course = new HashSet<Course>();

    public Student() {
    }

    public Student(int s_id, String s_code, String s_name, String s_password, Set<Course> course) {
        this.s_id = s_id;
        this.s_code = s_code;
        this.s_name = s_name;
        this.s_password = s_password;
        this.course = course;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_code() {
        return s_code;
    }

    public void setS_code(String s_code) {
        this.s_code = s_code;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_password() {
        return s_password;
    }

    public void setS_password(String s_password) {
        this.s_password = s_password;
    }

    public Set<Course> getCourse() {
        return course;
    }

    public void setCourse(Set<Course> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "s_id=" + s_id +
                ", s_code='" + s_code + '\'' +
                ", s_name='" + s_name + '\'' +
                ", s_password='" + s_password + '\'' +
                ", course=" + course +
                '}';
    }
}
