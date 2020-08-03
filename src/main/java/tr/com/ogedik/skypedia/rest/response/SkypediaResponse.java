package tr.com.ogedik.skypedia.rest.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;

/**
 * @author orkungedik
 */
public class SkypediaResponse extends ResponseEntity {

    public SkypediaResponse(HttpStatus httpStatus) {
        super(httpStatus);
    }

    public SkypediaResponse(Object body, HttpStatus httpStatus) {
        super(body, httpStatus);
    }


}
