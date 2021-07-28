package com.musala.task.service;

import com.musala.task.entity.DeviceEntity;
import com.musala.task.entity.GatewayEntity;
import com.musala.task.errorhandler.AlreadyExistException;
import com.musala.task.errorhandler.NotFoundException;
import com.musala.task.errorhandler.NotValidMoreThanTenException;
import com.musala.task.mapper.GatewayMapper;
import com.musala.task.model.Device;
import com.musala.task.model.Gateway;
import com.musala.task.repository.GatewayRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class GatewayService {
    @Autowired
    GatewayRepository gatewayRepository;
    @Autowired
    GatewayMapper gatewayMapper;
    @Autowired
    ModelMapper mapper;


    public List<Gateway> getAllGateways() {
        return gatewayMapper.mapEntityResponse(gatewayRepository.findAll());
    }

    public Gateway getGatewayBySerialNumber(String serialNumber) {
        GatewayEntity gatewayEntity = gatewayRepository.findBySerialNumber(serialNumber);
        if (gatewayEntity != null) {
            return gatewayMapper.mapEntityResponse(gatewayEntity);
        } else {
            throw new NotFoundException("Not Found Gateway with this serial number");
        }
    }

    public void addGateway(Gateway gateway) {
        try {
            GatewayEntity entity = convertGatewayDtoToGatewayEntity(gateway);
            gatewayRepository.saveAndFlush(entity);
        } catch (RuntimeException e) {
            throw new AlreadyExistException("Already exist Gateway");
        }
    }

    private GatewayEntity convertGatewayDtoToGatewayEntity(Gateway gateway) {
        return mapper.map(gateway, GatewayEntity.class);
    }

    private DeviceEntity convertDeviceDtoToDeviceEntity(Device device) {
        return mapper.map(device, DeviceEntity.class);
    }

    public void deleteDeviceBySerialNumberAndDeviceUID(String serialNumber, BigDecimal deviceUID) {
        GatewayEntity gatewayEntity = gatewayRepository.findBySerialNumber(serialNumber);
        if (gatewayEntity != null) {
            Optional<DeviceEntity> device = gatewayEntity.getDevices()
                    .stream()
                    .filter(deviceEntity -> deviceUID.equals(deviceUID))
                    .findFirst();
            if (device.isPresent()) {
                gatewayEntity.removeDevice(device.get());
                gatewayRepository.saveAndFlush(gatewayEntity);
            } else
                throw new NotFoundException("Device not found at the given gateway");
        }else{
            throw new NotFoundException("the given gateway not found"); //
        }
    }

    public void addDevice(String serialNumber, Device device) {
        GatewayEntity gatewayEntity = gatewayRepository.findBySerialNumber(serialNumber);
        if(gatewayEntity!= null) {
            if (!(gatewayEntity.getDevices().size() >= 10)) {
                gatewayEntity.addDevice(convertDeviceDtoToDeviceEntity(device));
                gatewayRepository.saveAndFlush(gatewayEntity);
            } else {
                throw new NotValidMoreThanTenException("Not Allowed to add more than 10 devices");
            }
        }else
            throw new NotFoundException("Not found Gateway");
    }
}
