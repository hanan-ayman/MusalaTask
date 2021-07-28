package com.musala.task.repository;

import com.musala.task.entity.DeviceEntity;
import com.musala.task.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, BigDecimal> {

}
