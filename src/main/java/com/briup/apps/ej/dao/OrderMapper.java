package com.briup.apps.ej.dao;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderExample;
import java.util.List;

import com.briup.apps.ej.bean.VM.dingdanVM;
import com.briup.apps.ej.bean.extend.orderExtend;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    //Order selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int deleteByPrimaryKey(Long id);//1.删除订单（查询删除）

    int insert(Order record);//2.插入订单

    int updateByPrimaryKey(Order record);//3.更新订单

    orderExtend findAllOrderById(Long id);//4.查询订单

    List<Order> findAllOrder();//5.查询所有订单

    List<Order> query(@Param("orderTime") Long orderTime,@Param("customerId") Long customerId,@Param("waiterId") Long waiterId,@Param("addressId") Long addressId);//6.模糊查询订单

//    List<Order> dingdanquery(@Param("status") String status);

    List<dingdanVM> dingdanquery(@Param("status")String status);

}