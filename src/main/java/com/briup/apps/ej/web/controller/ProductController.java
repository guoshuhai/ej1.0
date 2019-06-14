package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.bean.extend.ProductExtend;
import com.briup.apps.ej.service.ProductService;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.briup.apps.ej.utils.Message;
import java.util.List;
import com.briup.apps.ej.dao.extend.ProductExtendMapper;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
@Api(description = "产品管理相关的接口")
@RestController
@RequestMapping("/product")
@Validated



public class ProductController {

    @Autowired
    private ProductService productService;



    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Product product){
        List<Product> list = productService.query(product);
        return MessageUtil.success("success",list);
    }

    @ApiOperation("查询所有")
    @GetMapping("findAll")
    public Message findAll(){
        List<Product> list = productService.findAll();
        return MessageUtil.success("success",list);
    }
    @ApiOperation("通过id查询")
    @GetMapping("findById")
    public Message findById(
            @ApiParam(value = "主键",required = true)
            @RequestParam(value = "id") long id){
        Product user = productService.findById(id);
        return MessageUtil.success("success",user);
    }
    @ApiOperation("保存或更新用户信息")
    @PostMapping("Update")
    public Message Update(@Valid @ModelAttribute  Product product){
        try {
            productService.Update(product);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("通过id删除用户信息")
    @GetMapping("deleteById")
    public Message deleteById(@NotNull @ApiParam(value = "主键",required = true) @RequestParam("id") long id){
        try {
            productService.deleteById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error("删除失败");
        }
    }


    @ApiOperation("插入数据")
    @PostMapping("insert")
    public Message insert(@Valid @ModelAttribute Product product){
        try {
            productService.insert(product);
            return MessageUtil.success("插入成功");
        }catch (Exception e){
            e.printStackTrace();
            return  MessageUtil.error("id已存在");
        }
    }
    @ApiOperation("通过主键查询")
    @GetMapping("/selectByPrimaryKeyw")
    public Message selectByPrimaryKeyw(@ApiParam(value = "主键",required = true) @RequestParam(value = "id") long id){
        ProductExtend productExtend=productService.selectByPrimaryKeyw(id);
        return MessageUtil.success("查询成功!",productExtend);
    }
    @ApiOperation("批量删除")
    @PostMapping("/batchDelete")
    public Message batchDelete(@NotNull  (message = "id不能为空")long[] ids) throws Exception{
        productService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }


//    校验器


    @ApiOperation("保存或更新")
    @GetMapping("saveorupdate")
    public Message  saveorupdate(Product product) throws Exception {

         Product product1 = productService.findById(product.getId());

        if (product1==null){
            productService.insert(product);
            return MessageUtil.success("插入成功");


        }else {

            productService.Update(product);
            return MessageUtil.success("修改成功");
        }



    }

}