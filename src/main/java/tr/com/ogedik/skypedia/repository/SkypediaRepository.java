package tr.com.ogedik.skypedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.ogedik.skypedia.entity.SkypediaEntity;

/**
 * @author orkungedik
 */
public interface SkypediaRepository<T extends SkypediaEntity> extends JpaRepository<T, Long> {
}
