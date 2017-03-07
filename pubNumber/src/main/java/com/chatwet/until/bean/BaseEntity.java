package com.chatwet.until.bean;

import java.io.Serializable;

/**
 * Created by lixing on 2017/2/15.
 */
public interface BaseEntity extends Serializable {
    Integer getId();

    void setId(Integer var1);

    String toString();

    int hashCode();
}
