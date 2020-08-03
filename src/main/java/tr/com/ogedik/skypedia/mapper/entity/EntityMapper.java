package tr.com.ogedik.skypedia.mapper.entity;

import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;
import tr.com.ogedik.skypedia.entity.SkypediaEntity;
import tr.com.ogedik.skypedia.mapper.SkypediaMapper;
import tr.com.ogedik.skypedia.model.SkypediaModel;
import tr.com.ogedik.skypedia.model.MetaInformation;

/**
 * This is an abstract mapper class for business objects to entites.
 * @implSpec All entity mappers in the projects needs to extend this class to be able to prevent
 * code duplication and decrease code complexity
 *
 * @author orkungedik
 */
public abstract class EntityMapper<A extends SkypediaModel, B extends SkypediaEntity> extends SkypediaMapper<A, B> {

    @AfterMapping
    public void fillEntityMeta(A model, @MappingTarget B entity) {
        if (model.getMetaInformation() == null) {
            return;
        }
        entity.setCreatedAt(model.getMetaInformation().getCreatedAt());
        entity.setCreatedBy(model.getMetaInformation().getCreatedBy());
        entity.setUpdatedAt(model.getMetaInformation().getUpdatedAt());
        entity.setUpdatedBy(model.getMetaInformation().getUpdatedBy());
    }

    @AfterMapping
    public void fillBoMeta(@MappingTarget A model, B entity) {
        if (model.getMetaInformation() == null) {
            model.setMetaInformation(new MetaInformation());
        }
        model.getMetaInformation().setCreatedAt(entity.getCreatedAt());
        model.getMetaInformation().setCreatedBy(entity.getCreatedBy());
        model.getMetaInformation().setUpdatedAt(entity.getUpdatedAt());
        model.getMetaInformation().setUpdatedBy(entity.getUpdatedBy());
    }

}
