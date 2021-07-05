package com.demo.controller.mapper;

import com.demo.datatransferobject.CarDTO;
import com.demo.domainobject.CarDO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CarMapper
{
    public static CarDO makeCarDO(CarDTO dto)
    {
        CarDO carDO= new CarDO();
        carDO.setId(dto.getId());
        carDO.setConvertible(dto.getConvertible());
        carDO.setEngineType(dto.getEngineType());
        carDO.setRating(dto.getRating());
        carDO.setSeatCount(dto.getSeatCount());
        carDO.setLicensePlate(dto.getLicensePlate());
        return carDO;
    }


    public static CarDTO makeCarDTO(CarDO carDO)
    {
        CarDTO.CarDTOBuilder carDTOBuilder = CarDTO.newBuilder()
            .setId(carDO.getId())
            .setConvertible(carDO.getConvertible())
            .setSeatCount(carDO.getSeatCount())
            .setRating(carDO.getRating())
            .setLicensePlate(carDO.getLicensePlate())
            .setEngineType(carDO.getEngineType());
        return carDTOBuilder.createCarDTO();
    }


    public static List<CarDTO> makeCarDTOList(Collection<CarDO> carList)
    {
        return carList.stream()
            .map(CarMapper::makeCarDTO)
            .collect(Collectors.toList());
    }
}
