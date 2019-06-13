package com.briup.apps.ej.dao;

import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.CustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {

    long countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);


    int deleteByPrimaryKey(Long id)throws  Exception;


    int insert(Customer record) throws  Exception;


    int insertSelective(Customer record);


    List<Customer> selectByExample(CustomerExample example);


    Customer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);


    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);


    int updateByPrimaryKeySelective(Customer record);


    int updateByPrimaryKey(Customer record)throws  Exception;
    //模糊查询
    List<Customer> query(Customer customer)throws  Exception;

    //查询所有
    List<Customer> findAllcustomer()throws  Exception;


    Customer findUserByNameAndPwd(@Param("realname")String username,@Param("password")String password);

    Customer findByCustromName(String realname);



}