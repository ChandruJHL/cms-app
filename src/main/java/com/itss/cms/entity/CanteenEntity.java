package com.itss.cms.entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;


//inChargeId itemList available
@Entity
@Table(name="Canteen")
public class CanteenEntity {
    @Id
    @Column(name="Incharge_id")
    int inChargeId;
    @Column(name="ItemsList")
    String itemList;
    @Column(name="Available")
    String available;

    public int getInChargeId() {
        return inChargeId;
    }

    public void setInChargeId(int inChargeId) {
        this.inChargeId = inChargeId;
    }

    public String getItemList() {
        return itemList;
    }

    public void setItemList(String itemList) {
        this.itemList = itemList;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}
