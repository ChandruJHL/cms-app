package com.itss.cms.entity;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @Column(name = "student_id")
    private int studentId;

    @Column(name = "first_name")
    private String studentName;

    @Column(name = "age")
    private byte studentAge;
    @ManyToOne(cascade = CascadeType.ALL)
    private DepartmentEntity department;

    public DepartmentEntity getDepartment()
    {
        return department;
    }

    public void setDepartment(DepartmentEntity department)
    {
        this.department = department;
    }

    public String getStudentId()
    {
        return studentId;
    }

    public void setStudentId(int studentId)
    {
        this.studentId = studentId;
    }

    public String getStudentName()
    {
        return studentName;
    }

    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public byte getStudentAge()
    {
        return studentAge;
    }

    public void setStudentAge(byte studentAge) {
        this.studentAge = studentAge;
    }

}
