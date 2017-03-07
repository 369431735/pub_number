package com.chatwet.until.bean;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by lixing on 2017/3/1.
 */
@NoRepositoryBean
public interface EntityRepositoryInterFace<T,ID extends Serializable> extends PagingAndSortingRepository<T,ID> {
    public void doSomefhing(ID id);
}
