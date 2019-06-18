package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Order_line;
import com.briup.apps.ej.bean.extend.Order_line_Extend;
import com.briup.apps.ej.service.Order_lineService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Api(description = "订单项管理的相关接口")
@RestController
@RequestMapping("Order_line")
public class Order_lineController {

    @Autowired
    private Order_lineService orderLineService;

    @ApiOperation("输入id进行删除")
    @GetMapping("/deleteByPrimaryKey")
    public Message deleteByPrimaryKey(@ApiParam(value = "主键",required = true) @RequestParam(value = "id") long id){
        try {
            orderLineService.deleteByPrimaryKey(id);
            return MessageUtil.success("删除成功!");
        }catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("输入id进行查询")
    @GetMapping("findAllOrder_lineById")
    public Message findAllOrder_lineById(@ApiParam(value = "主键",required = true) @RequestParam(value = "id") Long id) throws Exception{
        Order_line_Extend order_line_extend=orderLineService.findAllOrder_lineById(id);
        if (MessageUtil.success("",order_line_extend).getData()!=null){
            return MessageUtil.success("success",order_line_extend);

        }else
        {  throw new Exception("此id不存在");
        }
    }

    @ApiOperation("查询所有")
    @GetMapping("findAllOrder_line")
    public Message findAllOrder_line(){
        List<Order_line_Extend> order_line_extends=orderLineService.findAllOrder_line();
        return MessageUtil.success("success",order_line_extends);
    }

    @ApiOperation("批量删除")
    @PostMapping("/betchDelete")
    public  Message  betchDelete(@NotNull(message = "id不能为空")long[] ids) throws Exception{
        orderLineService.betchDelete(ids);
        return  MessageUtil.success("删除成功");
    }

    @ApiOperation("保存或更新用户信息")
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Order_line orderLine){
        try {
            orderLineService.saveOrUpdate(orderLine);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("通过订单号编码进行查询")
    @GetMapping("/numberquery")
    public Message  numberquery(Integer number) throws Exception{
        List<Order_line>  list=orderLineService.numberquery(number);
        return MessageUtil.success("success",list);
    }

}
