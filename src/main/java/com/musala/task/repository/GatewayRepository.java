package com.musala.task.repository;

import com.musala.task.entity.GatewayEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GatewayRepository extends JpaRepository<GatewayEntity, String> {
    GatewayEntity findBySerialNumber(String serialNumber);

}
