package com.chatwet.until.bean;

import com.chatwet.until.json.JsonWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by lixing on 2017/2/15.
 */
@Component("entityAction")
public class EntityAction<T extends BaseEntity,X extends EntityService<T,EntityDao<T>> > {
    @Autowired
   private EntityService  entityService;
    //根据id查询数据
    @RequestMapping(value = "/findById")
    @ResponseBody
    public HashMap<String, Object> findById(Object id){
        return JsonWrapper.successWrapper((T)entityService.findById(id));
    }

    //根据id删除数据
    @RequestMapping(value = "/delectById")
    public  void delectById(Object id){
        entityService.delectById(id);
    }
    //查询所有数据
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public  HashMap<String, Object> findAll(){
        return   JsonWrapper.successWrapper((List<T>)entityService.findAll());
    }
    //保存单个数据
    @RequestMapping(value = "/sava")
    @ResponseBody
    public HashMap<String, Object> sava(T t){
      return  JsonWrapper.successWrapper((T)entityService.sava(t));
    }


}
