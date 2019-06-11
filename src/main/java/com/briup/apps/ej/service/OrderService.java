package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderExample;
import com.briup.apps.ej.bean.extend.orderExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderService {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_order
     *
     * @mbg.generated Mon Jun 10 13:33:10 CST 2019
     */


    long countByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_order
     *
     * @mbg.generated Mon Jun 10 13:33:10 CST 2019
     */
    int deleteByExample(OrderExample example) ;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_order
     *
     * @mbg.generated Mon Jun 10 13:33:10 CST 2019
     */
    int deleteByPrimaryKey(Long id) throws Exception;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_order
     *
     * @mbg.generated Mon Jun 10 13:33:10 CST 2019
     */
    int insert(Order record) throws Exception;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_order
     *
     * @mbg.generated Mon Jun 10 13:33:10 CST 2019
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_order
     *
     * @mbg.generated Mon Jun 10 13:33:10 CST 2019
     */
    List<Order> selectByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_order
     *
     * @mbg.generated Mon Jun 10 13:33:10 CST 2019
     */
    Order selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_order
     *
     * @mbg.generated Mon Jun 10 13:33:10 CST 2019
     */
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_order
     *
     * @mbg.generated Mon Jun 10 13:33:10 CST 2019
     */
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_order
     *
     * @mbg.generated Mon Jun 10 13:33:10 CST 2019
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_order
     *
     * @mbg.generated Mon Jun 10 13:33:10 CST 2019
     */
    int updateByPrimaryKey(Order record) throws  Exception;

    orderExtend findAllOrderById(Long id);

    List<Order>  findAllOrder();

    List<Order> query(Order order);
}

