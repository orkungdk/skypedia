package tr.com.ogedik.skypedia.model;

import lombok.Getter;
import lombok.Setter;
import tr.com.ogedik.skypedia.annotation.Required;

/**
 * @author orkungedik
 */
@Getter
@Setter
public class Airport extends SkypediaModel {

    @Required
    private String name;

    @Required
    private Location location;

}
