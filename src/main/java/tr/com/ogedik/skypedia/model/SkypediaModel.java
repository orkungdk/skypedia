package tr.com.ogedik.skypedia.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * it represents a Business Object. It should be used to define object hierarchy describing your functional model
 * @implSpec All business objects needs to have meta information.
 * @see MetaInformation
 *
 * @author orkun.gedik
 */
@Getter
@Setter
public abstract class SkypediaModel implements Serializable {

    private Long id;

    private MetaInformation metaInformation;

}
