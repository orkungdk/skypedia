package tr.com.ogedik.skypedia.util;

import tr.com.ogedik.skypedia.exception.ErrorType;
import tr.com.ogedik.skypedia.exception.SkypediaException;
import tr.com.ogedik.skypedia.model.SkypediaModel;
import tr.com.ogedik.skypedia.model.MetaInformation;

import java.time.LocalDateTime;

/**
 * @author orkun.gedik
 */
public class MetaUtils {

    /**
     * Fills meta information of the given authentication businessObject
     *
     * @param skypediaModel to be filled {@link SkypediaModel}
     * @param requestOwner   request owner
     */
    public static void fillMeta(SkypediaModel skypediaModel, String requestOwner) {
        if (skypediaModel == null) {
            throw new SkypediaException(ErrorType.INVALID_INPUT, "Request Body must not be null.");
        }

        if (skypediaModel.getMetaInformation() == null) {
            skypediaModel.setMetaInformation(new MetaInformation());
        }

        if (skypediaModel.getMetaInformation().getCreatedAt() == null) {
            skypediaModel.getMetaInformation().setCreatedAt(LocalDateTime.now());
            skypediaModel.getMetaInformation().setCreatedBy(requestOwner);
        } else {
            skypediaModel.getMetaInformation().setUpdatedAt(LocalDateTime.now());
            skypediaModel.getMetaInformation().setUpdatedBy(requestOwner);
        }
    }
}
