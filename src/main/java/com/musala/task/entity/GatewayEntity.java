package com.musala.task.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "gateway")
@Getter
@Setter
public class GatewayEntity {
    @Id
    private String serialNumber;
    private String humanName;
    private String IPv4;
    @OneToMany(mappedBy = "gateway" , cascade = CascadeType.ALL , orphanRemoval = true)
    private List<DeviceEntity> devices = new ArrayList<>();

    public void addDevice(DeviceEntity device){
        devices.add(device);
        device.setGateway(this);
    }
    public void removeDevice(DeviceEntity device){
        devices.remove(device);
        device.setGateway(null);
    }
}
