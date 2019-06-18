package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Order_line;
import com.briup.apps.ej.bean.Order_lineExample;
import com.briup.apps.ej.bean.extend.Order_line_Extend;
import com.briup.apps.ej.dao.Order_lineMapper;
import com.briup.apps.ej.service.Order_lineService;
import com.briup.apps.ej.utils.MessageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Order_lineServiceImpl implements Order_lineService {

    @Resource
    private Order_lineMapper orderLineMapper;
    @Override
    public long countByExample(Order_lineExample example) {
        return orderLineMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(Order_lineExample example) {
        return orderLineMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) throws Exception {
        Order_line orderLine=orderLineMapper.findAllOrder_lineById(id);
        if(MessageUtil.success("",orderLine).getData()==null){
            throw new Exception("要删除的用户不存在");
        }else {
            return orderLineMapper.deleteByPrimaryKey(id);
        }
    }


    @Override
    public int insertSelective(Order_line record) {
        return orderLineMapper.insertSelective(record);
    }

    @Override
    public List<Order_line> selectByExample(Order_lineExample example) {
        return orderLineMapper.selectByExample(example);
    }

    /**@Override
    public Order_line selectByPrimaryKey(Long id) {
        return orderLineMapper.selectByPrimaryKey(id);
    }**/

    @Override
    public int updateByExampleSelective(Order_line record, Order_lineExample example) {
        return orderLineMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Order_line record, Order_lineExample example) {
        return orderLineMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Order_line record) {
        return orderLineMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Order_line_Extend findAllOrder_lineById(Long id) throws Exception {
        Order_line_Extend orderLine=orderLineMapper.findAllOrder_lineById(id);
        if (MessageUtil.success("",orderLine).getData()!=null){
            return orderLine;
        }else {
            throw new Exception("查找的订单项不存在");
        }
    }

    @Override
    public List<Order_line_Extend> findAllOrder_line() {
        return orderLineMapper.findAllOrder_line();
    }

    @Override
    public void betchDelete(long[] ids) throws Exception {
        for(long id:ids){
            orderLineMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void saveOrUpdate(Order_line orderLine) throws Exception {
        if (orderLine.getId() == null) {
            // 初始化属性
            orderLineMapper.insert(orderLine);
        } else {
            Order_line order = orderLineMapper.findAllOrder_lineById(orderLine.getId());
            if (MessageUtil.success("", order).getData() != null) {
                orderLineMapper.updateByPrimaryKey(orderLine);
            } else {
                throw new Exception("用户不存在");
            }
        }
    }

    @Override
    public List<Order_line> numberquery(Integer number) throws Exception{
        if (number!=null){
            List<Order_line> orderLine=orderLineMapper.numberquery(number);
            if (MessageUtil.success("",orderLine).getData().toString()!="[]"){
                return orderLineMapper.numberquery(number);
            }else {
                throw new Exception("您输入的用户编码不存在");
            }
        }else{
            throw new Exception("请输入用户编码");
        }

    }
}
