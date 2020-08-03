package tr.com.ogedik.skypedia.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tr.com.ogedik.skypedia.entity.AirlineCompanyEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author orkungedik
 */
@Repository
public interface AirlineCompanyRepository extends SkypediaRepository<AirlineCompanyEntity> {

    @Query("select a from AirlineCompanyEntity a where a.name = :name or a.shortName = :shortName")
    Optional<AirlineCompanyEntity> findAirlineCompany(@Param("name") String name, @Param("shortName") String shortName);

    @Query("select a from AirlineCompanyEntity a where (:name is not null and a.name like %:name%) or" +
            " (:shortName is not null and a.shortName like %:shortName%)")
    List<AirlineCompanyEntity> search(@Param("name") String name, @Param("shortName") String shortName);
}
