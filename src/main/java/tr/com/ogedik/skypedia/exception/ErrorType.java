package tr.com.ogedik.skypedia.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.hateoas.mediatype.problem.Problem;

/**
 * This enum represents error type in the project. Each error type has a specific title and http status code.
 *
 * @author orkungedik
 */
@Getter
@AllArgsConstructor
public enum ErrorType {

    INTERNAL_ERROR("Internal Server Error", 500),
    INVALID_INPUT("Invalid Input Value", 400),
    MISSING_FIELD_VALUE("Mandatory Field Missing", 400),
    NO_SEARCH_CRITERIA("No Search Criteria Found.", 400),
    ALREADY_EXISTED_DATA("Data Already Exists.", 400);

    private String title;
    private int status;
    }
