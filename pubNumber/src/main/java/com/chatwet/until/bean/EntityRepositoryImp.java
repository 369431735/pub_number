package com.chatwet.until.bean;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by lixing on 2017/3/1.
 */
public class EntityRepositoryImp<T extends BaseEntity, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements EntityRepositoryInterFace<T, ID> {
private final EntityManager entityManager;
public EntityRepositoryImp(Class<T> domainClass, EntityManager entityManager){
    super(domainClass,entityManager);
    this.entityManager=entityManager;
}
    @Override
    public void doSomefhing(ID id) {

    }
}
