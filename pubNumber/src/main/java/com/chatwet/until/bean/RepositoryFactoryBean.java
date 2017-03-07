package com.chatwet.until.bean;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by lixing on 2017/3/1.
 */
public class RepositoryFactoryBean<T extends JpaRepository<S,ID>,S,ID extends Serializable> extends JpaRepositoryFactoryBean<T,S,ID> {
    @Override
    protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
        return new EntityRepository(entityManager);
    }

    private static  class  EntityRepository extends JpaRepositoryFactory{
        public EntityRepository(EntityManager entityManager){
            super(entityManager);
        }
        @Override
        @SuppressWarnings({"unchecked"})
        protected <T,ID extends  Serializable>SimpleJpaRepository<?,?> getTargetRepository(RepositoryInformation information,EntityManager entityManager){
            return new EntityRepositoryImp<T,ID>((Class<T>)information.getDomainType(),entityManager);}
          @Override
            protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata){return EntityRepositoryImp.class;}
}
    }
