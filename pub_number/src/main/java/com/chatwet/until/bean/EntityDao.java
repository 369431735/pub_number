package com.chatwet.until.bean;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lixing on 2017/2/15.
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
@Component
public class EntityDao<T extends BaseEntity> extends HibernateDaoSupport {
    @Autowired
    private EntityDaoInterFace entityDaoInterFace;

    //根据id查询数据
    public  T findById(Object id){
        if(id==null){ return null;}
       else if(id instanceof  String){
            return   (T)entityDaoInterFace.findOne((String)id);
        }
        else  if(String.valueOf(id).equals("")){
            return   (T)entityDaoInterFace.findOne(String.valueOf(id));
        }
        return null;
    }
    //根据id删除数据
    public  void delectById(Object id){
         if(id instanceof  String){
               entityDaoInterFace.delete((String)id);
        }
        else  if(String.valueOf(id).equals("")){
               entityDaoInterFace.delete(String.valueOf(id));
        }

    }
    //查询所有数据
    public List<T> findAll(){
            return   (List<T>)entityDaoInterFace.findAll();
    }
     //保存单个数据
     public T sava(T t){
        entityDaoInterFace.save(t);
         return t;
     }


    //获得Session
    public  Session findSession()  {
        return super.getSessionFactory().getCurrentSession();
    }


}

