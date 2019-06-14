package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.bean.extend.CategoryExtend;
import com.briup.apps.ej.dao.CategoryMapper;
import com.briup.apps.ej.service.CategoryService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Api(description = "分类管理相关的接口")
@Validated
@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @ApiOperation("删除分类")
    @GetMapping("delete")
    public Message deleteByPrimaryKey(@NotNull @RequestParam("id") Long id) throws  Exception{

        Category category = categoryService.selectByPrimaryKey(id);
        if (category.getId()!=null){

        categoryService.deleteByPrimaryKey(id);
        return MessageUtil.success("success");

    }else{
            throw new Exception("删除失败");

    }
    }



    @ApiOperation("通过id更新分类")
    @PostMapping("update")
    public Message updateByPrimaryKey( Category record) throws  Exception{
        Category category = categoryService.selectByPrimaryKey(record.getId());
        if (category!=null) {
            categoryService.updateByPrimaryKey(record);
            return MessageUtil.success("更新成功");
        }else{
        return MessageUtil.success("id不存在");}
    }


    @ApiOperation("通过id查询分类")
    @GetMapping("select")
    public Message selectByPrimaryKey(@NotNull @RequestParam("id") Long id){

        Category i = categoryService.selectByPrimaryKey(id);

        return MessageUtil.success("success",i);
    }



    @ApiOperation("查询所有分类")
    @GetMapping("findAll")
    public Message findAll() {

        List<Category> all = categoryService.findAll();



        return  MessageUtil.success("success",all);
    }



    @ApiOperation("添加分类")
    @PostMapping("insert")
    public Message insert(@Valid @ModelAttribute("record") Category record) throws  Exception{

        Category category = categoryService.selectByPrimaryKey(record.getId());
        if (category==null) {
            categoryService.insert(record);
            return MessageUtil.success("添加成功");
        }else{
            return MessageUtil.success("id已存在");}
    }




    @ApiOperation("通过名子查询分类")
    @GetMapping("findcategorybyname")
    public Message findcategorybyname(@Valid @ModelAttribute("name") String name) throws  Exception {


            CategoryExtend findcategorybyname = categoryService.findcategorybyname(name);
        if(findcategorybyname==null) {
            Category findcategorybynamedouble = categoryService.findcategorybynamedouble(name);


            return MessageUtil.success("success", findcategorybynamedouble);

        }


        return MessageUtil.success("success", findcategorybyname);
    }



    @PostMapping("batchDelete")
    @ApiOperation("批量删除分类信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") @RequestParam("ids") long[] ids) throws Exception{
        categoryService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
    //

    @GetMapping("query")
    @ApiOperation("模糊查询")
    public Message query(Category category) throws Exception{
            List<Category> list=categoryService.query(category);
        return MessageUtil.success("success",list);
    }


    @ApiOperation("保存或更新")
    @GetMapping("saveorupdate")
    public Message  saveorupdate(Category category) throws Exception {

        Category category1 = categoryService.selectByPrimaryKey(category.getId());

        if (category == null) {
            categoryService.insert(category);
            return MessageUtil.success("插入成功");


        } else {

            categoryService.updateByPrimaryKey(category);
            return MessageUtil.success("修改成功");
        }


    }
    }



