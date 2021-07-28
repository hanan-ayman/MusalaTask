package com.musala.task.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Id;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "device")
@Getter
@Setter
@NoArgsConstructor
public class DeviceEntity {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private BigDecimal uid;
    private String vendor;
    @Column(name = "DATE_CREATED" ,nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime dateCreated;
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SERIAL_NUMBER" , nullable = false)
    private GatewayEntity gateway;
}
