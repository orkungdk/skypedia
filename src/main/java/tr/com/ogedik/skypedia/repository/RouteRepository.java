package tr.com.ogedik.skypedia.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tr.com.ogedik.skypedia.entity.RouteEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author orkungedik
 */
@Repository
public interface RouteRepository extends SkypediaRepository<RouteEntity> {


    @Query("select a from RouteEntity a where (:departureId is not null and a.departure.id = :departureId) or" +
            " (:destinationId is not null and a.destination.id = :destinationId)")
    List<RouteEntity> findAllByDepartureIdAndDestinationId(@Param("departureId") Long departureId,
                                                           @Param("destinationId") Long destinationId);

}
