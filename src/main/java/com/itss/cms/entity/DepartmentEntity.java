package com.itss.cms.entity;
import javax.persistence.*;
import java.util.List;

//departmentId departmentName hodName totalStudent totalStaff
@Entity
@Table(name="department")
public class DepartmentEntity{
    @Id
    @Column(name = "Department_id")
    private String  departmentId;

    @Column(name ="Department_name")
    private String departmentName;

    @Column(name = "HOD_name")
    private String hodName;

    @Column(name ="TotalStudent")
    private int totalStudent;

    @Column(name ="TotalStaff")
    private int totalStaff;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    List<StudentEntity> students;

    public List<StudentEntity> getStudents()
    {
        return students;
    }

    public void setStudents(List<StudentEntity> students)
    {
        this.students = students;
    }
    public String getDepartmentId()
    {
        return departmentId;
    }

    public void setDepartmentId(String departmentId)
    {
        this.departmentId = departmentId;
    }

    public String getDepartmentName()
    {
        return departmentName;
    }

    public void setDepartmentName(String departmentName)
    {
        this.departmentName = departmentName;
    }
    public String getHodName()
    {
        return hodName;
    }
    public void setHodName(String hodName)
    {
        this.hodName = hodName;
    }
    public int getTotalStudent()
    {
        return totalStudent;
    }
    public void setTotalStudent(int totalStudent)
    {
        this.totalStudent = totalStudent;
    }
    public int getTotalStaff()
    {
        return totalStaff;
    }
    public void setTotalStaff(int totalStaff)
    {
        this.totalStaff = totalStaff;
    }
}
