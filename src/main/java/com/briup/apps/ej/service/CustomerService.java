package com.briup.apps.ej.service;


import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.bean.CustomerExample;
import com.briup.apps.ej.bean.extend.CustomerExtend;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface CustomerService {


    long countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record) ;


    //以下是能够用到的
    List<Customer> findAllcustomer() throws Exception;

    List <Customer> query(Customer customer) throws Exception;

    Customer selectByPrimaryKey(Long id) throws Exception;

    int insert(Customer record) throws Exception;

    //int updateByPrimaryKey(Customer record)throws  Exception;

    void saveOrUpdate(Customer customer) throws Exception;

    void batchDelete(long[] ids) throws  Exception;

    int deleteByPrimaryKey(Long id) throws Exception;

    void regist(Customer customer ) throws Exception;

    Customer findUserByNameAndPwd(String realname,String password);
    Customer findByCustromName(String realname);


     List<CustomerExtend> findAddressById(Long id);







}