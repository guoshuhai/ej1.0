package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.service.CategoryService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @ApiOperation("delete")
    @GetMapping("delete")
    public Message deleteByPrimaryKey(Long id){

        int i = categoryService.deleteByPrimaryKey(id);

        return MessageUtil.success("success",i);


    }



    @ApiOperation("update")
    @GetMapping("update")
    public Message updateByPrimaryKey(Category record){

        int i = categoryService.updateByPrimaryKey(record);

        return MessageUtil.success("success",i);


    }


    @ApiOperation("select")
    @GetMapping("select")
    public Message selectByPrimaryKey(Long id){

        Category i = categoryService.selectByPrimaryKey(id);

        return MessageUtil.success("success",i);
    }


    @ApiOperation("select")
    @GetMapping("select")
    public Message insert(Category record){

        int insert = categoryService.insert(record);

        return MessageUtil.success("success",insert);


    }
}

