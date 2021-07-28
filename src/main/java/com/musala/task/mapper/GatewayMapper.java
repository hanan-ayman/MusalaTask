package com.musala.task.mapper;

import com.musala.task.model.Device;
import com.musala.task.entity.DeviceEntity;
import com.musala.task.entity.GatewayEntity;
import com.musala.task.model.Gateway;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GatewayMapper {
    public List<Gateway> mapEntityResponse(List<GatewayEntity> gatewayEntities) {
        List<Gateway> gateways = new ArrayList<>();
        for (GatewayEntity entity : gatewayEntities) {
            Gateway gateway = new Gateway();
            gateway.setSerialNumber(entity.getSerialNumber());
            gateway.setHumanName(entity.getHumanName());
            gateway.setIpv4(entity.getIPv4());
            gateway.setDevices(mapDeviceEntityResponse(entity.getDevices()));
            gateways.add(gateway);
        }
        return gateways;
    }

    public Gateway mapEntityResponse(GatewayEntity entity) {
        Gateway gateway = new Gateway();
        gateway.setSerialNumber(entity.getSerialNumber());
        gateway.setHumanName(entity.getHumanName());
        gateway.setIpv4(entity.getIPv4());
        gateway.setDevices(mapDeviceEntityResponse(entity.getDevices()));
        return gateway;
    }

    public List<Device> mapDeviceEntityResponse(List<DeviceEntity> deviceEntities) {
        List<Device> devices = new ArrayList<>();
        for (DeviceEntity entity : deviceEntities) {
            Device device = new Device();
            device.setUid(entity.getUid());
            device.setDateCreated(entity.getDateCreated().toString());
            device.setStatus(Device.StatusEnum.fromValue(entity.getStatus()));
            device.setVendor(entity.getVendor());
            devices.add(device);
        }
        return devices;
    }
}
