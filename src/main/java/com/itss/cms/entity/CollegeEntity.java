package com.itss.cms.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//contactNumber, collegeName,city
@Entity
@Table (name="college_management")
public class CollegeEntity {
    @Id
    @Column(name="contact_number")
    int contactNumber;
    @Column(name="CollegeName")
    String collegeName;
    @Column(name="City")
    String city;


    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }
}
