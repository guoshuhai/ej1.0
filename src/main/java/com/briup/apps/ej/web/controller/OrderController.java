package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.extend.orderExtend;
import com.briup.apps.ej.service.OrderService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import com.sun.org.apache.xpath.internal.operations.Or;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**@GetMapping("/selectByPrimaryKey")
    public Message selectByPrimaryKey(@ApiParam(value = "主键",required = true) @RequestParam(value = "id")long id){
        Order order=orderService.selectByPrimaryKey(id);
        return MessageUtil.success("success",order);
    }**/

    @ApiOperation("输入id进行删除")
    @GetMapping("/deleteByPrimaryKey")
    public Message deleteByPrimaryKey(@ApiParam(value = "主键",required = true) @RequestParam(value = "id")long id ){
        try {
            orderService.deleteByPrimaryKey(id);
            return MessageUtil.success("删除成功!");
        }catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("不输入id进行插入")
    @GetMapping("/insert")
    public  Message  insert(Order record){
        try {
            orderService.insert(record);
            return MessageUtil.success("插入成功!");
        }catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("输入id进行更新")
    @GetMapping("/updateByPrimaryKey")
    public Message updateByPrimaryKey(Order record){
        try {
            orderService.updateByPrimaryKey(record);
            return MessageUtil.success("修改成功!");
        }catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }


    @ApiOperation("输入id进行查询")
    @GetMapping("/findAllOrderById")
    public Message findAllOrderById(@ApiParam(value = "主键",required = true) @RequestParam(value = "id")long id ){
        orderExtend orderExtend=orderService.findAllOrderById(id);
        return MessageUtil.success("success",orderExtend);
    }

    @ApiOperation("查询所有")
    @GetMapping("findAllOrder")
    public  Message findAllOrder(){
        List<Order>  list =orderService.findAllOrder();
        return MessageUtil.success("查询成功!",list);
    }

    @ApiOperation("模糊查询")
    @GetMapping("/query")
    public Message  query(Order order){
        List<Order>  list=orderService.query(order);
        return MessageUtil.success("success",list);
    }


}

