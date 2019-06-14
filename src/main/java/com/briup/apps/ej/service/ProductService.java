package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.bean.extend.ProductExtend;

import java.util.List;

public interface ProductService {

    List<Product> query(Product product);

    List<Product> findAll();

    Product findById(long id);


    void Update(Product product) throws Exception ;
//    插入数据
    void insert(Product product) throws  Exception;



//    根据Id删除
    void deleteById(long id) throws Exception ;

    void batchDelete(long[] ids) throws  Exception;

//    根据主键删除

    ProductExtend selectByPrimaryKeyw(long id);

}
