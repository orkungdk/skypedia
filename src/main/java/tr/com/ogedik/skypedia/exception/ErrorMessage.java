package tr.com.ogedik.skypedia.exception;

import lombok.*;

/**
 * @author orkungedik
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorMessage {

    private Integer status;
    private String title;
    private String detail;
    private String pointer;

    public ErrorMessage(ErrorType errorType, String detail, String pointer) {
        this.status = errorType.getStatus();
        this.title = errorType.getTitle();
        this.detail = detail;
        this.pointer = pointer;
    }
}

