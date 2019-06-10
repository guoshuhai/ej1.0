package com.briup.apps.ej.web.controller;


import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.service.AddressService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.MessageUtils;

@RestController
@RequestMapping("Address")
public class AddressController {

    @Autowired
    private AddressService AddressService;


    @ApiOperation("insert")
    @GetMapping("insert")
    public Message   insert(Address record) throws  Exception{
    try {
        AddressService.insert(record);
        return MessageUtil.success("success");
    }
        catch (Exception e){
         throw new Exception(e.getMessage());

        }
    }

    @ApiOperation("select")
    @GetMapping("select")
    public Message  selectByPrimaryKey(Long id){

        Address address = AddressService.selectByPrimaryKey(id);
        return MessageUtil.success("success",address);
    }

    @ApiOperation("delete")
    @GetMapping("delete")
    public Message deleteByPrimaryKey(Long id) throws  Exception {
        Address address = AddressService.selectByPrimaryKey(id);

        if (address.getId() != null) {
            AddressService.deleteByPrimaryKey(id);
            return MessageUtil.success("success");
        } else {
            throw new Exception("用户不存在");
        }
    }


        @ApiOperation("update")
        @GetMapping("update")
    public Message  updateByPrimaryKey(Address record) throws Exception {
        try {
            AddressService.updateByPrimaryKey(record);
            return MessageUtil.success("success");
        }catch (Exception e){
            e.printStackTrace();
            return  MessageUtil.error("删除失败");

        }
    }


}
