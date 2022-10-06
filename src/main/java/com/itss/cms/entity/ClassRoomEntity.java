package com.itss.cms.entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;

//studentId staffId classId section departmentId
@Entity
@Table (name="class_room")
public class ClassRoomEntity {
    @Id
    @Column(name="student_id")
    int studentId;
    @Column(name="staff_id")
    int staffId;
    @Column(name="classId")
    String classId;
    @Column(name="section")
    String section;
    @Column(name="DepartmentId")
    String departmentId;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
