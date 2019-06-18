package com.briup.apps.ej.dao;

import com.briup.apps.ej.bean.Order_line;
import com.briup.apps.ej.bean.Order_lineExample;
import java.util.List;

import com.briup.apps.ej.bean.extend.Order_line_Extend;
import org.apache.ibatis.annotations.Param;

public interface Order_lineMapper {

    long countByExample(Order_lineExample example);

    int deleteByExample(Order_lineExample example);

    int deleteByPrimaryKey(Long id);//

    int insert(Order_line record);//

    int insertSelective(Order_line record);

    List<Order_line> selectByExample(Order_lineExample example);

   // Order_line selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Order_line record, @Param("example") Order_lineExample example);

    int updateByExample(@Param("record") Order_line record, @Param("example") Order_lineExample example);

    int updateByPrimaryKeySelective(Order_line record);

    int updateByPrimaryKey(Order_line record);//

        //查询订单项通过id
       Order_line_Extend findAllOrder_lineById(Long id) throws Exception;//

       //查询所有的订单项
       List<Order_line_Extend> findAllOrder_line();//

       List<Order_line> numberquery(@Param("number") Integer number);//6.模糊查询订单



}