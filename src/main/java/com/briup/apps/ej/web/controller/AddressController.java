package com.briup.apps.ej.web.controller;


import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.service.AddressService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sun.misc.MessageUtils;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
@Api(description = "地址管理相关的接口")
@Validated
@RestController
@RequestMapping("Address")
public class AddressController {

    @Autowired
    private AddressService AddressService;


    @ApiOperation("添加地址")
    @PostMapping("insert")
    public Message   insert(@Valid @ModelAttribute("record") Address record) throws  Exception{
        Address address = AddressService.selectByPrimaryKey(record.getId());
        if (address==null) {
            AddressService.insert(record);

            return MessageUtil.success("success");
        }else {
            return MessageUtil.error("id已存在");
        }
    }

    @ApiOperation("查询地址")
    @GetMapping("select")
    public Message  selectByPrimaryKey(@NotNull @RequestParam("id")Long id){

        Address address = AddressService.selectByPrimaryKey(id);
        return MessageUtil.success("success",address);
    }

    @ApiOperation("删除地址")
    @GetMapping("delete")
    public Message deleteByPrimaryKey(@NotNull @RequestParam("id") Long id) throws  Exception {
        Address address = AddressService.selectByPrimaryKey(id);

        if (address.getId() != null) {
            AddressService.deleteByPrimaryKey(id);
            return MessageUtil.success("success");
        } else {
            throw new Exception("用户不存在");
        }
    }


        @ApiOperation("更新地址")
        @PostMapping("update")
    public Message  updateByPrimaryKey( Address record) throws Exception {
            Address address = AddressService.selectByPrimaryKey(record.getId());
            if (address!=null) {
                AddressService.updateByPrimaryKey(record);

                return MessageUtil.success("success");
            }else {
                return MessageUtil.error("用户不存在");
            }

    }
    @ApiOperation("模糊查询地址")
    @GetMapping("query")
    public Message  query(Address address ) throws Exception {

        List<Address> query = AddressService.query(address);

        return MessageUtil.success("success",query);



    }

    @ApiOperation("查询所有地址信息")
    @GetMapping("findAllAddress")
    public Message  findAllAddress() throws Exception {

        List<Address> alladdress = AddressService.findAlladdress();

        return MessageUtil.success("success",alladdress);



    }

    @ApiOperation("保存或更新")
    @GetMapping("saveorupdate")
    public Message  saveorupdate(Address address) throws Exception {

        Address address1 = AddressService.selectByPrimaryKey(address.getId());

        if (address1==null){
                AddressService.insert(address);
                return MessageUtil.success("插入成功");


        }else {

            AddressService.updateByPrimaryKey(address);
            return MessageUtil.success("修改成功");
        }



    }
}
