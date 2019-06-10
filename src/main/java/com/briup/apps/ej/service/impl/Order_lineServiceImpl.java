package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Order_line;
import com.briup.apps.ej.bean.Order_lineExample;
import com.briup.apps.ej.bean.extend.Order_line_Extend;
import com.briup.apps.ej.dao.Order_lineMapper;
import com.briup.apps.ej.service.Order_lineService;
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
        Order_line orderLine=orderLineMapper.selectByPrimaryKey(id);
        if(orderLine.getId()==null){
            throw new Exception("要删除的用户不存在");
        }else {
            return orderLineMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int insert(Order_line record) throws  Exception {
        if(record.getId()==null){
            return orderLineMapper.insert(record);
        }else {
            throw new Exception("请不要输入id值");
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

    @Override
    public Order_line selectByPrimaryKey(Long id) {
        return orderLineMapper.selectByPrimaryKey(id);
    }

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
    public int updateByPrimaryKey(Order_line record) throws Exception{
        if (record!=null){
            return orderLineMapper.updateByPrimaryKey(record);
        }else {
            throw new Exception("请输入id值");
        }

    }

    @Override
    public Order_line_Extend findAllOrder_lineById(Long id)  {

        return orderLineMapper.findAllOrder_lineById(id);
    }

    @Override
    public List<Order_line_Extend> findAllOrder_line() {
        return orderLineMapper.findAllOrder_line();
    }
}
