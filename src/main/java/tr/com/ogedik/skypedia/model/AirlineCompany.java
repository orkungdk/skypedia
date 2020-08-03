package tr.com.ogedik.skypedia.model;

import lombok.Getter;
import lombok.Setter;
import tr.com.ogedik.skypedia.annotation.Required;

/**
 * @author orkungedik
 */
@Getter
@Setter
public class AirlineCompany extends SkypediaModel {

    @Required
    private String name;

    @Required
    private String shortName;

    private MetaInformation metaInformation;

}
