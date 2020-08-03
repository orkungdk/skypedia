package tr.com.ogedik.skypedia.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author orkungedik
 */
@Getter
@Setter
public class MetaInformation {

    private String createdBy;

    private String updatedBy;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
