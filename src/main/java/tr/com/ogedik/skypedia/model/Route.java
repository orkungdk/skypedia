package tr.com.ogedik.skypedia.model;

import lombok.Getter;
import lombok.Setter;
import tr.com.ogedik.skypedia.annotation.Required;

/**
 * @author orkungedik
 */
@Getter
@Setter
public class Route extends SkypediaModel {

    @Required
    private Airport departure;

    @Required
    private Airport destination;

    private Long distance;

    private int estimatedFlightTime;

}
