package com.itss.cms.dto;
import com.itss.cms.entity.DepartmentEntity;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

public class StudentRequest {
    private int id;
    private String name;
    private byte age;

    @ManyToOne(cascade = CascadeType.ALL)
    private DepartmentEntity department;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public byte getAge()
    {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }
}
