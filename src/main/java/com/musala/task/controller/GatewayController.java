package com.musala.task.controller;

import com.musala.task.GatewayApi;
import com.musala.task.model.Device;
import com.musala.task.model.Gateway;
import com.musala.task.service.GatewayService;
import com.musala.task.validate.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class GatewayController implements GatewayApi {
    private static final Logger log = LoggerFactory.getLogger(GatewayController.class);
    @Autowired
    private GatewayService service;

    @Override
    public ResponseEntity<Void> addGateway(@Valid Gateway gateway) {
        log.debug("START: addGateway");
        Validator.isIpv4(gateway.getIpv4());
        service.addGateway(gateway);
        log.debug("FINISH: addGateway");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Void> addDevice(String serialNumber, @Valid Device device) {
        log.debug("START: addDevice");
        service.addDevice(serialNumber , device);
        log.debug("FINISH: addDevice");
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Void> deleteDevice(String serialNumber, @NotNull @Valid BigDecimal deviceUID) {
        log.debug("START: deleteDevice");
        service.deleteDeviceBySerialNumberAndDeviceUID(serialNumber , deviceUID);
        log.debug("FINISH: deleteDevice");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<Gateway>> getAllGateways() {
        log.debug("START: getAllGateways");
        List<Gateway> gateways = service.getAllGateways();
        log.debug("FINISH: getAllGateways");
        return new ResponseEntity<>(gateways, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Gateway> getOneGateway(String serialNumber) {
        log.debug("START: getOneGateway");
        Gateway gateway = service.getGatewayBySerialNumber(serialNumber);
        log.debug("FINISH: getOneGateway");
        return new ResponseEntity<>(gateway, HttpStatus.OK);
    }
}
