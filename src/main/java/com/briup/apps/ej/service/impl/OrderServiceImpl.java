package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.OrderExample;
import com.briup.apps.ej.bean.extend.orderExtend;
import com.briup.apps.ej.dao.OrderMapper;
import com.briup.apps.ej.service.OrderService;
import org.springframework.stereotype.Service;
import com.briup.apps.ej.web.controller.CustomerController;
import com.briup.apps.ej.web.controller.WaiterController;
import com.briup.apps.ej.web.controller.AddressController;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public long countByExample(OrderExample example) {
        return  orderMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderExample example) {
        return orderMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) throws Exception {
        Order order=orderMapper.selectByPrimaryKey(id);
        if(order.getId()==null){
            throw new Exception("要删除的用户不存在");
        }
        else{
           return orderMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int insert(Order record)throws Exception {
        int customer_id=0,waiter_id=0,address_id=0;
       CustomerController customerService=new CustomerController();
        WaiterController waiterController=new WaiterController();
        AddressController addressController=new AddressController();
        if (record.getId()==null){
            if((record.getCustomerId()!=null)&&(customerService.selectById(record.getCustomerId().longValue())!=null)){
                customer_id=1;
            }
            if((record.getWaiterId()!=null)&&(waiterController.findById(record.getWaiterId().longValue())!=null)){
                waiter_id=1;
            }
            if ((record.getAddressId()!=null)&&(addressController.selectByPrimaryKey(record.getAddressId())!=null)){
                address_id=1;
            }
           if((record.getCustomerId()!=null&&(customer_id==1))&&((record.getWaiterId()!=null))&&(waiter_id==1)&&(record.getAddressId()!=null&&address_id==1)){
               return orderMapper.insert(record);
           }else {
               throw new Exception("外键错误，外键值不存在");
           }

        }
        else {
            throw new Exception("请不要输入id值");
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
    public Order selectByPrimaryKey(Long id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Order record, OrderExample example) {
        return orderMapper.updateByExampleSelective(record,example);
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
    public int updateByPrimaryKey(Order record) throws Exception {
        int customer_id=0,waiter_id=0,address_id=0;
        CustomerServiceImpl customerController=new CustomerServiceImpl();
        WaiterController waiterController=new WaiterController();
        AddressController addressController=new AddressController();
        if (record.getId()==null){
            if(record.getCustomerId()!=null&&customerController.selectByPrimaryKey(record.getCustomerId())!=null){
                customer_id=1;
            }
            if(record.getWaiterId()!=null&&waiterController.findById(record.getWaiterId())!=null){
                waiter_id=1;
            }
            if (record.getAddressId()!=null&&addressController.selectByPrimaryKey(record.getAddressId())!=null){
                address_id=1;
            }
            if((record.getCustomerId()!=null&&customer_id==1)&&(record.getWaiterId()!=null&&waiter_id==1)&&(record.getAddressId()!=null&&address_id==1)) {
                return orderMapper.insert(record);
            }else {
                throw new Exception("外键错误，外键值不存在");
            }
        }
       else {
            throw new Exception("请不要输入id值");
        }
    }

    @Override
    public orderExtend findAllOrderById(Long id)  {
        return orderMapper.findAllOrderById(id);
    }

    @Override
    public List<Order>  findAllOrder() {
        return orderMapper.findAllOrder();
    }

    @Override
    public List<Order> query(Order order) {
        return orderMapper.query(order);
    }
}
