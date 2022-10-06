package com.itss.cms.entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
@Entity
@Table(name="parking")
public class ParkingEntity {

    @Id
    @Column(name="slot_id")
    int slotId;
    @Column(name="vehicle_number")
    String vehicleNumber;
    @Column(name="vechicle_ownername")
    String vehicleOwnerName;

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }
}
