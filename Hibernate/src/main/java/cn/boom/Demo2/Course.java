package cn.boom.Demo2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Course {

    private Integer c_id;
    private String c_code;
    private String c_info;

    private Set<Student> students = new HashSet<Student>();

    public Course() {

    }

    public Course(Integer c_id, String c_code, String c_info, Set<Student> students) {
        this.c_id = c_id;
        this.c_code = c_code;
        this.c_info = c_info;
        this.students = students;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_code() {
        return c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public String getC_info() {
        return c_info;
    }

    public void setC_info(String c_info) {
        this.c_info = c_info;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "c_id=" + c_id +
                ", c_code='" + c_code + '\'' +
                ", c_info='" + c_info + '\'' +
                ", students=" + students +
                '}';
    }
}
