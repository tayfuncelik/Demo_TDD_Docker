package com.demo.service.car;

import com.demo.domainobject.CarDO;
import com.demo.exception.ConstraintsViolationException;
import com.demo.exception.EntityNotFoundException;

import java.util.List;

public interface CarService {
    CarDO find(Long driverId) throws EntityNotFoundException;

    CarDO create(CarDO carDO) throws ConstraintsViolationException;

    void delete(Long carId) throws EntityNotFoundException;

    void update(CarDO carDO) throws EntityNotFoundException;

    List<CarDO> findAll();

}
