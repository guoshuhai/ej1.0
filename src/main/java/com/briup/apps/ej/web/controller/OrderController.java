package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.extend.orderExtend;
import com.briup.apps.ej.service.OrderService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import com.sun.org.apache.xpath.internal.operations.Or;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

import com.briup.apps.ej.dao.OrderMapper;
@Api(description = "订单管理相关的接口")
@Validated
@RestController
@RequestMapping("Order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    /**@GetMapping("/selectByPrimaryKey")
    public Message selectByPrimaryKey(@ApiParam(value = "主键",required = true) @RequestParam(value = "id")long id){
        Order order=orderService.selectByPrimaryKey(id);
        return MessageUtil.success("success",order);
    }**/

    @ApiOperation("输入id进行删除")
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

    @ApiOperation("不输入id进行插入")
    @PostMapping("/insert")
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
    @PostMapping("/updateByPrimaryKey")
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
        System.out.println(id);
        //orderExtend orderExtend=orderService.findAllOrderById(id);//这句本质上等同orderExtend orderExtend=orderMapper.findAllOrderById(id)，也就是orderService.findAllOrderById(id)=>orderMapper.findAllOrderById(id)，但是数据流会出错
        //orderExtend  orderExtend=orderMapper.findAllOrderById(id);
        //System.out.println(orderExtend.getOrderTime());
        orderExtend orderExtend=orderService.findAllOrderById(id);
        //System.out.println(orderExtend.getOrderTime());//干扰值,因为id不存在的时候，orderExtend对象是空的，所以再查这个对象属性的时候就会抛空异常
        return MessageUtil.success("success",orderExtend);//针对干扰值，id不存在时候的对象放在Message中，实现返回null
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


    @ApiOperation("批量删除")
    @PostMapping("/betchDelete")
    public Message betchDelete(@NotNull(message = "id不能为空")long[] ids) throws Exception{
     orderService.betchDelete(ids);
     return MessageUtil.success("批量删除成功");
    }


}

