package tr.com.ogedik.skypedia.model;

import lombok.Getter;
import lombok.Setter;
import tr.com.ogedik.skypedia.annotation.Required;

import java.util.List;

/**
 * @author orkungedik
 */
@Getter
@Setter
public class Location extends SkypediaModel {

    @Required
    private String country;

    @Required
    private String city;

    @Required
    private String latitude;

    @Required
    private String longitude;

    private List<Airport> airports;

}
