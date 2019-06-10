package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Order_line;
import com.briup.apps.ej.service.Order_lineService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Order_line")
public class Order_lineController {

    @Autowired
    private Order_lineService orderLineService;

    @GetMapping("/selectByPrimaryKey")
    public Message selectByPrimaryKey(@ApiParam(value = "主键",required = true) @RequestParam(value = "id") long id){
        Order_line orderLine=orderLineService.selectByPrimaryKey(id);
        return MessageUtil.success("success",orderLine);
    }

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

    @GetMapping("/insert")
    public Message insert(Order_line record){
        try {
            orderLineService.insert(record);
            return MessageUtil.success("插入成功!");
        }catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @GetMapping("/updateByPrimaryKey")
    public Message updateByPrimaryKey(Order_line record){
        try {
            orderLineService.updateByPrimaryKey(record);
            return MessageUtil.success("更新成功!");
        }catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
}
