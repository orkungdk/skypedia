package tr.com.ogedik.skypedia.service;

import tr.com.ogedik.skypedia.model.AirlineCompany;
import tr.com.ogedik.skypedia.model.SkypediaModel;

import java.util.List;

/**
 * it represents a service. It should be used to define object hierarchy describing service classes
 *
 * @author orkungedik
 */
public interface SkypediaService<T extends SkypediaModel> {

    T create(T model);

    T retrieveById(Long id);

    List<T> search(T searchRequest);
}
