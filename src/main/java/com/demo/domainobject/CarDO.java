package com.demo.domainobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "car")
//, uniqueConstraints = @UniqueConstraint(name = "uc_driverDO", columnNames = {"driverDO"})
public class CarDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    private String licensePlate;
    private Integer seatCount;
    private Boolean convertible;
    private String rating;
    private String engineType;//electric,gas

    @OneToOne(mappedBy = "carDO")
    private DriverDO driverDO;

}
