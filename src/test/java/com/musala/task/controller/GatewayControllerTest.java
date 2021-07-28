package com.musala.task.controller;


import com.musala.task.model.Device;
import com.musala.task.model.Gateway;
import com.musala.task.service.GatewayService;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(value = GatewayController.class ,excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class GatewayControllerTest {
    @Autowired
    MockMvc mvc;
    @MockBean
    private GatewayService service;
    List<Gateway> gateways ;
    Gateway gateway;
    @Before
    public void setUp() {
        List<Device> list = new ArrayList<>();
        Device device1 = new Device();
        device1.setUid(BigDecimal.valueOf(1));
        device1.setDateCreated(LocalDateTime.now().toString());
        device1.setStatus(Device.StatusEnum.ONLINE);
        Device device2 = new Device();
        device2.setUid(BigDecimal.valueOf(2));
        device2.setDateCreated(LocalDateTime.now().toString());
        device2.setStatus(Device.StatusEnum.OFFLINE);
        list.add(device1);
        list.add(device2);

        gateway = new Gateway();
        gateway.serialNumber("zKbMLFgxh");
        gateway.setHumanName("Default gateway");
        gateway.setIpv4("192.168.1.0");
        gateway.setDevices(list);

        gateways = new ArrayList<>(Arrays.asList(gateway));
    }

    @Test
    public void getAllGatewaysRecords_Success() throws Exception {
        //given //when
        given(service.getAllGateways()).willReturn(gateways);
        //then
        mvc.perform(get("/gateway")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].serialNumber", is(gateways.get(0).getSerialNumber())));
    }

    @Test
    public void getOneGateway_Success() throws Exception {
        given(service.getGatewayBySerialNumber("zKbMLFgxh")).willReturn(gateway);
        mvc.perform(get("/gateway/zKbMLFgxh")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", isA(LinkedHashMap.class)));
    }
}