package com.chatwet.until.bean;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lixing on 2017/2/15.
 */
public interface EntityDaoInterFace<T extends BaseEntity> extends JpaRepository<T,String> {
}
