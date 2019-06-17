package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.VM.OrderAndOrderLineVM;
import com.briup.apps.ej.bean.VM.OrderVM;
import com.briup.apps.ej.bean.extend.orderExtend;
import com.briup.apps.ej.service.OrderService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import com.sun.org.apache.xpath.internal.operations.Or;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

import com.briup.apps.ej.dao.OrderMapper;

@Api(description = "订单管理系统的相关接口")
@Validated
@RestController
@RequestMapping("Order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @ApiOperation("输入id进行订单删除")
    @GetMapping("/deleteByPrimaryKey")
    public Message deleteByPrimaryKey(@ApiParam(value = "主键",required = true) @RequestParam(value = "id") long id ){
        try {
            orderService.deleteByPrimaryKey(id);
            return MessageUtil.success("删除成功!");
        }catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("输入id进行查询")
    @GetMapping("/findAllOrderById")
    public Message findAllOrderById(@ApiParam(value = "主键",required = true) @RequestParam(value = "id")long id ) throws Exception {
        try {
            orderExtend orderExtend = orderService.findAllOrderById(id);
            return MessageUtil.success("success", orderExtend);
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("查询所有订单")
    @GetMapping("findAllOrder")
    public  Message findAllOrder(){
        List<Order>  list =orderService.findAllOrder();
        return MessageUtil.success("查询成功!",list);
    }

    @ApiOperation("批量删除订单")
    @PostMapping("/betchDelete")
    public Message betchDelete(@NotNull(message = "id不能为空")long[] ids) throws Exception{
     orderService.betchDelete(ids);
     return MessageUtil.success("批量删除成功");
    }

    @GetMapping("queryBasic")
    @ApiOperation("查询指定订单信息，返回列表数据")
    public Message queryBasic(Long customerId,Long waiterId)throws Exception{
        List<OrderVM> list = orderService.queryBasic(customerId,waiterId);
        return MessageUtil.success("success",list);
    }

    @PostMapping("save")
    @ApiOperation("保存订单信息")
    public Message insert(@Valid @ModelAttribute OrderAndOrderLineVM order) throws Exception{
        orderService.save(order);
        return MessageUtil.success("操作成功");
    }

    @ApiOperation("保存或更新用户信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Order order){
        try {
            orderService.saveOrUpdate(order);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("全局性模糊查询,针对内部调用所开发")
    @GetMapping("/query")
    public Message  query(Long orderTime,Long customerId,Long waiterId,Long addressId){
        List<Order>  list=orderService.query(orderTime,customerId,waiterId,addressId);
        return MessageUtil.success("success",list);
    }


}

