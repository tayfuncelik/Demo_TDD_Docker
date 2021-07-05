package com.demo.service.driver;

import com.demo.datatransferobject.CarSelectDTO;
import com.demo.datatransferobject.DriverDTO;
import com.demo.domainobject.DriverDO;
import com.demo.domainvalue.OnlineStatus;
import com.demo.exception.CarAlreadyInUseException;
import com.demo.exception.ConstraintsViolationException;
import com.demo.exception.EntityNotFoundException;

import java.util.List;

public interface DriverService {

    DriverDO find(Long driverId) throws EntityNotFoundException;

    DriverDO create(DriverDO driverDO) throws ConstraintsViolationException;

    void delete(Long driverId) throws EntityNotFoundException;

    void updateLocation(long driverId, double longitude, double latitude) throws EntityNotFoundException;

    List<DriverDO> find(OnlineStatus onlineStatus);

    void selectCar(CarSelectDTO carSelectDTO) throws EntityNotFoundException, CarAlreadyInUseException;

    void deSelectCar(CarSelectDTO carSelectDTO) throws EntityNotFoundException;

    List<DriverDO> findDriverByParams(DriverDTO driverDTO);
}
