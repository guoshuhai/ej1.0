package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderExample;
import com.briup.apps.ej.bean.VM.OrderAndOrderLineVM;
import com.briup.apps.ej.bean.VM.OrderVM;
import com.briup.apps.ej.bean.VM.dingdanVM;
import com.briup.apps.ej.bean.extend.orderExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {

    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example) ;


    int deleteByPrimaryKey(Long id) throws Exception;

   // int insert(Order record) throws Exception;

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    //Order selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

   // int updateByPrimaryKey(Order record) throws  Exception;

    orderExtend findAllOrderById(Long id) throws Exception;

    List<Order>  findAllOrder();

    List<Order> query(Long orderTime,Long customerId,Long waiterId,Long addressId);

    void betchDelete(long[] ids) throws Exception;//批量删除订单

    void saveOrUpdate(Order order) throws Exception ;

    List<OrderVM> queryBasic(Long customerId, Long waiterId) throws Exception;

    void save(OrderAndOrderLineVM order) throws Exception;

//    List<Order> dingdanquery(String status);;

    List<dingdanVM> dingdanquery(String status);
}

