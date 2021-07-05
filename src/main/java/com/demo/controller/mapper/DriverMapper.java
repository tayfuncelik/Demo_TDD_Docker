package com.demo.controller.mapper;

import com.demo.datatransferobject.DriverDTO;
import com.demo.domainobject.CarDO;
import com.demo.domainobject.DriverDO;
import com.demo.domainvalue.GeoCoordinate;
import com.demo.domainvalue.OnlineStatus;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DriverMapper {
    public static DriverDO makeDriverDO(DriverDTO driverDTO) {
        DriverDO driverDO = new DriverDO();
        driverDO.setId(driverDO.getId());
        driverDO.setDeleted(driverDO.getDeleted());
        driverDO.setOnlineStatus(driverDO.getOnlineStatus());
        driverDO.setPassword(driverDO.getPassword());
        driverDO.setPassword(driverDO.getPassword());
        driverDO.setDateCoordinateUpdated(driverDO.getDateCoordinateUpdated());
        return driverDO;
    }


    public static DriverDTO makeDriverDTO(DriverDO driverDO) {
        DriverDTO.DriverDTOBuilder driverDTOBuilder = DriverDTO.newBuilder()
                .setId(driverDO.getId())
                .setPassword(driverDO.getPassword())
                .setUsername(driverDO.getUsername());

        GeoCoordinate coordinate = driverDO.getCoordinate();
        if (coordinate != null) {
            driverDTOBuilder.setCoordinate(coordinate);
        }
        CarDO carDO = driverDO.getCarDO();
        if (carDO != null) {
            driverDTOBuilder.setCarDTO(CarMapper.makeCarDTO(carDO));
        }

        OnlineStatus onlineStatus = driverDO.getOnlineStatus();
        if (onlineStatus != null) {
            driverDTOBuilder.setOnlineStatus(onlineStatus);
        }
        return driverDTOBuilder.createDriverDTO();
    }


    public static List<DriverDTO> makeDriverDTOList(Collection<DriverDO> drivers) {
        return drivers.stream()
                .map(DriverMapper::makeDriverDTO)
                .collect(Collectors.toList());
    }
}
