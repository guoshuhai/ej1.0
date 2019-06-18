package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.*;
import com.briup.apps.ej.bean.VM.OrderAndOrderLineVM;
import com.briup.apps.ej.bean.VM.OrderVM;
import com.briup.apps.ej.bean.extend.orderExtend;
import com.briup.apps.ej.dao.OrderMapper;
import com.briup.apps.ej.dao.Order_lineMapper;
import com.briup.apps.ej.dao.extend.OrderExtendMapperadd;
import com.briup.apps.ej.service.OrderService;
import com.briup.apps.ej.utils.MessageUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import com.briup.apps.ej.service.CustomerService;
import com.briup.apps.ej.service.WaiterService;
import com.briup.apps.ej.service.AddressService;
import com.briup.apps.ej.service.OrderService;
//import com.briup.apps.ej.service.impl.CustomerServiceImpl;
//import com.briup.apps.ej.dao.CustomerMapper;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private Order_lineMapper orderLineMapper;

    @Resource
    OrderExtendMapperadd orderExtendMapperadd;

    @Override
    public long countByExample(OrderExample example) {
        return orderMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderExample example) {
        return orderMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) throws Exception {
        Order order = orderMapper.findAllOrderById(id);
        if (MessageUtil.success("",order) .getData()== null) {
            throw new Exception("要删除的用户不存在");
        } else {
            return orderMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public List<Order> selectByExample(OrderExample example) {
        return orderMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(Order record, OrderExample example) {
        return orderMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Order record, OrderExample example) {
        return orderMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }


    @Override
    public orderExtend findAllOrderById(Long id) throws Exception{
        Order order=orderMapper.findAllOrderById(id);
        if(MessageUtil.success("",order).getData()==null){
            throw new Exception("查询的用户不存在");
        }
        return orderMapper.findAllOrderById(id);
    }

    @Override
    public List<Order> findAllOrder() {
        return orderMapper.findAllOrder();
    }


    @Override
    public void betchDelete(long[] ids) throws Exception {
        for(long id:ids){
            orderMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<OrderVM> queryBasic(Long customerId, Long waiterId) throws Exception{
        if (customerId!=null){
            List<Order> order=orderMapper.query(null,customerId,null,null);
            if (MessageUtil.success("",order).getData().toString()!="[]"){
                if (waiterId!=null){
                    List<Order> order1=orderMapper.query(null,null,waiterId,null);
                    if (MessageUtil.success("",order1).getData().toString()!="[]"){
                        return orderExtendMapperadd.queryBasic(customerId,waiterId);
                    }else{
                        throw new Exception("服务人员不存在");
                    }
                }else{
                    return orderExtendMapperadd.queryBasic(customerId,waiterId);
                }
            }else{
                throw new Exception("客户不存在");
            }
        }else {
            if (waiterId!=null){
                List<Order> order2=orderMapper.query(null,null,waiterId,null);
                if (MessageUtil.success("",order2).getData().toString()!="[]"){//因为无法比较MessageUtil.success("",order2).getData()返回的是一个对象，所以要.toString()进行String化才能比较
                    System.out.println(MessageUtil.success("",order2).getData().toString());
                    return orderExtendMapperadd.queryBasic(customerId,waiterId);
                }else{
                    throw new Exception("服务人员不存在");
                }
        }
        return orderExtendMapperadd.queryBasic(customerId,waiterId);
     }
    }

    @Override
    public void save(OrderAndOrderLineVM order) throws Exception {
        // 先保存订单
        Order o = new Order();
        o.setOrderTime(new Date().getTime());
        o.setTotal(100.0);
        o.setCustomerId(order.getCustomerId());
        o.setAddressId(order.getAddressId());
        orderMapper.insert(o);
        // 再保存订单项
        List<Order_line> list = order.getOrderLines();
        for(Order_line ol : list){
            // 维护订单项与订单之间的关系
            ol.setOrderId(o.getId());
            orderLineMapper.insert(ol);
        }
    }

    @Override
    public void saveOrUpdate(Order orders) throws Exception {
        if(orders.getId() == null){
            // 初始化属性
            orderMapper.insert(orders);
        } else {
            Order order=orderMapper.findAllOrderById(orders.getId());
            if (MessageUtil.success("",order).getData()!=null) {
               orderMapper.updateByPrimaryKey(orders);
            }else{
                throw new Exception("用户不存在");
            }
        }
    }

    @Override
    public List<Order> query(Long orderTime,Long customerId,  Long waiterId, @Param("addressId") Long addressId) {
        return orderMapper.query(orderTime,customerId,waiterId,addressId);
    }
}
