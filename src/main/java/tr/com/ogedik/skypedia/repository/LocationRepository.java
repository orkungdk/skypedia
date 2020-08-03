package tr.com.ogedik.skypedia.repository;

import org.springframework.stereotype.Repository;
import tr.com.ogedik.skypedia.entity.LocationEntity;

import java.util.Optional;

/**
 * @author orkungedik
 */
@Repository
public interface LocationRepository extends SkypediaRepository<LocationEntity> {

    Optional<LocationEntity> findByCountryAndCity(String country, String city);
}
