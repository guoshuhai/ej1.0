package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.bean.extend.ProductExtend;
import com.briup.apps.ej.service.ProductService;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.briup.apps.ej.utils.Message;
import java.util.List;
import com.briup.apps.ej.dao.extend.ProductExtendMapper;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;



    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Product product){
        List<Product> list = productService.query(product);
        return MessageUtil.success("success",list);
    }


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
    @GetMapping("saveOrUpdate")
    public Message saveOrUpdate(Product user){
        try {
            productService.saveOrUpdate(user);
            return MessageUtil.success("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }

    @ApiOperation("通过id删除用户信息")
    @GetMapping("deleteById")
    public Message deleteById(@ApiParam(value = "主键",required = true) @RequestParam("id") long id){
        try {
            productService.deleteById(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }


    @ApiOperation("插入数据")
    @GetMapping("insert")
    public Message insert(Product product){
        try {
            productService.insert(product);
            return MessageUtil.success("插入成功");
        }catch (Exception e){
            e.printStackTrace();
            return  MessageUtil.error(e.getMessage());
        }
    }

    @GetMapping("/selectByPrimaryKeyw")
    public Message selectByPrimaryKey(@ApiParam(value = "主键",required = true) @RequestParam(value = "id") long id){
        ProductExtend productExtend=productService.selectByPrimaryKeyw(id);
        return MessageUtil.success("查询成功!",productExtend);
    }
    @ApiOperation("批量删除")
    @PostMapping("/batchDelete")
    public Message batchDelete(@NotNull(message = "id不能为空")long[] ids) throws Exception{
        productService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
}