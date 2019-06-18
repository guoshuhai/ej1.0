package com.briup.apps.ej.web.controller;


import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.Customer;
import com.briup.apps.ej.service.CustomerService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
@Api(description = "顾客管理相关的接口")
@Validated
@RestController
@RequestMapping("customer")
public class CustomerController {


    @Autowired
    private CustomerService customerService;


    @ApiOperation("查询所有顾客信息")
    @GetMapping("findAllCustomer")
    public Message findAllCustomer() throws Exception {
        List<Customer> list = customerService.findAllcustomer();
        return MessageUtil.success("success", list);
    }

    @ApiOperation("通过主键查询")
    @GetMapping("selectById")
    public Message selectById(
            @ApiParam(value = "主键", required = true)
            @RequestParam(value = "id") long id) throws Exception {
        Customer customer = customerService.selectByPrimaryKey(id);
//        CustomerServiceImpl customerService=new CustomerServiceImpl();//测试数据根据CustomerServiceImpl还是customerService流动：答案是后者
//        Customer customer=customerService.selectByPrimaryKey(id);
        return MessageUtil.success("success", customer);
    }


    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Customer customer) throws Exception {
        List<Customer> list = customerService.query(customer);
        return MessageUtil.success("success", list);
    }

    @ApiOperation("添加顾客信息")
    @PostMapping("insert")
    public Message insert(
            @Valid
            @ModelAttribute
            @ApiParam(required = true) Customer record) throws Exception {

        int insert = customerService.insert(record);
        return MessageUtil.success("success", insert);
    }

//    @ApiOperation("更新顾客信息")
//    @PostMapping("update")
//    public Message updateByPrimaryKey(Customer record) throws Exception{
//
//        int update=customerService.updateByPrimaryKey(record);
//        return MessageUtil.success("success",update);
//    }

    @ApiOperation("保存或更新顾客信息")
    @PostMapping("saveOrUpdate")
    public Message saveOrUpdate(@ModelAttribute Customer customer) {
        try {
            customerService.saveOrUpdate(customer);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("通过id删除信息")
    @GetMapping("deleteById")
    public Message deleteById(@ApiParam(value = "主键", required = true) @RequestParam("id") Long id) throws Exception {
        try {
            customerService.deleteByPrimaryKey(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @PostMapping("batchDelete")
    @ApiOperation("批量删除顾客信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception {
        customerService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }

    @GetMapping("login")
    @ApiOperation("登录")
    public Message login(String realname, String password) throws Exception {
        Customer userByNameAndPwd = customerService.findUserByNameAndPwd(realname, password);

        if (userByNameAndPwd != null) {
            System.out.println("登录成功");
            return MessageUtil.success("登录成功");

        } else {

            return MessageUtil.error("登录失败");
        }
    }


    @GetMapping("regist")
    @ApiOperation("注册")
    public Message regist(Customer customer) throws Exception {
        String realname = customer.getRealname();
        Customer byCustromName = customerService.findByCustromName(realname);
        if (byCustromName == null) {

            customerService.insert(customer);
            return MessageUtil.success("注册成功");
        } else {
            return MessageUtil.error("用户已存在");
        }
    }

    @ApiOperation("通过顾客id查询地址")
    @GetMapping("findAddressById")
    public Message findAddressById(@Valid @RequestParam("id") Long id) throws Exception {
        List<Address> addressById = customerService.findAddressById(id);
        return MessageUtil.success("success", addressById);
    }
}


