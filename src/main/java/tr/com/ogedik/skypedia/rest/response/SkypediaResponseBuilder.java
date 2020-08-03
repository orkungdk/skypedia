package tr.com.ogedik.skypedia.rest.response;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;

/**
 * This is a builder class for {@link SkypediaResponse}.
 *
 * @author orkungedik
 */
@UtilityClass
public class SkypediaResponseBuilder {

    /**
     * Returns OK response.
     * @see HttpStatus#OK
     *
     * @return {@link SkypediaResponse}
     */
    public static SkypediaResponse OK() {
        return new SkypediaResponse(HttpStatus.OK);
    }

    /**
     * Returns BAD_REQUEST response.
     * @see HttpStatus#BAD_REQUEST
     *
     * @return {@link SkypediaResponse}
     */
    public static SkypediaResponse KO() {
        return new SkypediaResponse(HttpStatus.BAD_REQUEST);
    }

    /**
     * Builds a response message by the given object.
     *
     * @param object response body
     * @return {@link SkypediaResponse}
     */
    public static SkypediaResponse build(Object object) {
        if (ObjectUtils.isEmpty(object)) {
            return new SkypediaResponse(HttpStatus.NO_CONTENT);
        } else {
            return new SkypediaResponse(object, HttpStatus.OK);
        }
    }

    /**
     * Returns a response message by the given boolean value
     *
     * @implNote Use this method only for the methods that check existence of an object
     * @param value boolean
     * @return {@link SkypediaResponse}
     */
    public static SkypediaResponse build(boolean value) {
        if (value) {
            return new SkypediaResponse(HttpStatus.OK);
        } else {
            return new SkypediaResponse(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Returns a response message with the given parameters
     *
     * @param object response body
     * @param httpStatus response status
     * @return {@link SkypediaResponse}
     */
    public static SkypediaResponse build(Object object, HttpStatus httpStatus) {
        return new SkypediaResponse(object, httpStatus);
    }
}
