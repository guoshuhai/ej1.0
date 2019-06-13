package com.briup.apps.ej.service;


import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.CustomerExample;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface CustomerService {


    long countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Long id) throws Exception;

    int insert(Customer record) throws  Exception;

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    List <Customer> query(Customer customer);

    List<Customer> findAllcustomer();

     void batchDelete(long[] ids) throws  Exception;


     void regist(Customer customer ) throws Exception;

    Customer findUserByNameAndPwd(String realname,String password);

    Customer findByCustromName(String realname);









}