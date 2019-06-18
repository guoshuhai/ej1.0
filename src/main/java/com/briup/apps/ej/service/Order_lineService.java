package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Order_line;
import com.briup.apps.ej.bean.Order_lineExample;
import com.briup.apps.ej.bean.extend.Order_line_Extend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Order_lineService {

    long countByExample(Order_lineExample example);

    int deleteByExample(Order_lineExample example);


    int deleteByPrimaryKey(Long id) throws Exception;//删除


   // int insert(Order_line record) throws Exception;//插入

    int insertSelective(Order_line record);

    List<Order_line> selectByExample(Order_lineExample example);

    //Order_line selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Order_line record, @Param("example") Order_lineExample example);

    int updateByExample(@Param("record") Order_line record, @Param("example") Order_lineExample example);

    int updateByPrimaryKeySelective(Order_line record);

    //int updateByPrimaryKey(Order_line record) throws Exception;//更新

    //查询订单项通过id
    Order_line_Extend findAllOrder_lineById(Long id)throws Exception;

    //查询所有的订单项
    List<Order_line_Extend> findAllOrder_line() ;

    void betchDelete(long[] ids) throws Exception;

    void saveOrUpdate(Order_line orderLine) throws Exception ;

    List<Order_line> numberquery(Integer number) throws Exception;
}

