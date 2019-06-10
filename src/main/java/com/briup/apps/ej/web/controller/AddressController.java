package com.briup.apps.ej.web.controller;


import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.AddressExample;
import com.briup.apps.ej.service.AddressService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Address")
public class AddressController {

    @Autowired
    private AddressService AddressService;


    @ApiOperation("select")
    @GetMapping("insert")
    public Message   insert(Address record){

        int insert = AddressService.insert(record);
        return MessageUtil.success("success",insert);
    }

    @ApiOperation("insert")
    @GetMapping("insert")
    public Message  selectByPrimaryKey(Long id){

        Address address = AddressService.selectByPrimaryKey(id);
        return MessageUtil.success("success",address);
    }

    @ApiOperation("delete")
    @GetMapping("delete")
    public Message deleteByPrimaryKey(Long id){
        int i = AddressService.deleteByPrimaryKey(id);
        return MessageUtil.success("success",i);
    }
    @ApiOperation("uopdate")
    @GetMapping("update")
    public Message  updateByPrimaryKey(Address record){
        AddressService.updateByPrimaryKey(record);
        return MessageUtil.success("success");
    }


}
