package com.demo.dataaccessobject;

import com.demo.datatransferobject.DriverDTO;
import com.demo.domainobject.DriverDO;
import com.demo.domainvalue.OnlineStatus;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Database Access Object for driver table.
 * <p/>
 */
public interface DriverRepository extends CrudRepository<DriverDO, Long>
{

    List<DriverDO> findByOnlineStatus(OnlineStatus onlineStatus);

    DriverDO findByOnlineStatusIsAndCarDOId(OnlineStatus onlineStatus, Long carId);

    @Query("select d from DriverDO d where "

        + " (:#{#driverDTO.coordinate.point} is null OR d.coordinate.point = :#{#driverDTO.coordinate.point})"
        + " AND (:#{#driverDTO.deleted} is null OR d.deleted = :#{#driverDTO.deleted})"
        + " AND (:#{#driverDTO.username} is null OR d.username = :#{#driverDTO.username})"
        + " AND (:#{#driverDTO.onlineStatus} is null OR d.onlineStatus = :#{#driverDTO.onlineStatus})"

        + " AND (:#{#driverDTO.carDTO.licensePlate} is null OR d.carDO.licensePlate = :#{#driverDTO.carDTO.licensePlate})"
        + " AND (:#{#driverDTO.carDTO.engineType} is null OR d.carDO.engineType = :#{#driverDTO.carDTO.engineType})"
        + " AND (:#{#driverDTO.carDTO.rating} is null OR d.carDO.rating = :#{#driverDTO.carDTO.rating})"
        + " AND (:#{#driverDTO.carDTO.seatCount} is null OR d.carDO.seatCount = :#{#driverDTO.carDTO.seatCount})"
        + " AND (:#{#driverDTO.carDTO.convertible} is null OR d.carDO.convertible = :#{#driverDTO.carDTO.convertible})"
    )
    List<DriverDO> findByParams(@Param("driverDTO") DriverDTO driverDTO);
}
