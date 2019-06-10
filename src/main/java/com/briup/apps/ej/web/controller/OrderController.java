package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.service.OrderService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Order")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/selectByPrimaryKey")
    public Message selectByPrimaryKey(@ApiParam(value = "主键",required = true) @RequestParam(value = "id")long id){
        Order order=orderService.selectByPrimaryKey(id);
        return MessageUtil.success("success",order);
    }

    @GetMapping("/deleteByPrimaryKey")
    public Message deleteByPrimaryKey(@ApiParam(value = "主键",required = true) @RequestParam(value = "id")long id ){
        orderService.deleteByPrimaryKey(id);
        return MessageUtil.success("删除成功!");
    }

    @GetMapping("/insert")
    public  Message  insert(Order record){
        orderService.insert(record);
        return MessageUtil.success("插入成功!");
    }

    @GetMapping("/updateByPrimaryKey")
    public Message updateByPrimaryKey(Order record){
        orderService.updateByPrimaryKey(record);
        return MessageUtil.success("修改成功!");
    }


}

