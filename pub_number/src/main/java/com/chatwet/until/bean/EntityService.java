package com.chatwet.until.bean;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lixing on 2017/2/15.
 */
@Transactional
@Component("entityService")
public class EntityService<T extends BaseEntity, D extends EntityDao<T>> {
    @Autowired
    private EntityDao entityDao;
    //根据id查询数据
    public   T findById(Object id){
            return   (T)entityDao.findById(id);
        }

    //根据id删除数据
    public  void delectById(Object id){
            entityDao.delectById(id);
    }
    //查询所有数据
    public List<T> findAll(){
        return   (List<T>)entityDao.findAll();
    }
    //保存单个数据
    public T sava(T t){
        return  (T)entityDao.sava(t);

    }


    //获得Session
    public Session findSession()  {
        return entityDao.findSession();
    }
}
