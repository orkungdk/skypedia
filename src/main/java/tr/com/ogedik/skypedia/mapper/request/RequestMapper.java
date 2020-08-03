package tr.com.ogedik.skypedia.mapper.request;

import tr.com.ogedik.skypedia.mapper.SkypediaMapper;
import tr.com.ogedik.skypedia.model.SkypediaModel;
import tr.com.ogedik.skypedia.rest.request.SkypediaRequest;

/**
 * This is an abstract mapper class for requests to business objects.
 * @implSpec All request mappers in the projects needs to extend this class to be able to prevent
 * code duplication and decrease code complexity
 *
 * @author orkungedik
 */
public abstract class RequestMapper<A extends SkypediaModel, B extends SkypediaRequest> extends SkypediaMapper<A,B> {

}
