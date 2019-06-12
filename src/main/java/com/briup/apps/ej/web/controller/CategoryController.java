package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.bean.extend.CategoryExtend;
import com.briup.apps.ej.service.CategoryService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @ApiOperation("delete")
    @GetMapping("delete")
    public Message deleteByPrimaryKey(Long id) throws  Exception{

        Category category = categoryService.selectByPrimaryKey(id);
        if (category.getId()!=null){

        return MessageUtil.success("success");

    }else{
            throw new Exception("删除失败");

    }
    }



    @ApiOperation("update")
    @GetMapping("update")
    public Message updateByPrimaryKey(Category record) throws  Exception{
    try {
        int i = categoryService.updateByPrimaryKey(record);

        return MessageUtil.success("success",i);

    }catch (Exception e){
        e.printStackTrace();
        return  MessageUtil.error(e.getMessage());

    }

//a

    }


    @ApiOperation("select")
    @GetMapping("select")
    public Message selectByPrimaryKey(Long id){

        Category i = categoryService.selectByPrimaryKey(id);

        return MessageUtil.success("success",i);
    }



    @ApiOperation("findAll")
    @GetMapping("findAll")
    public Message findAll() {

        List<Category> all = categoryService.findAll();



        return  MessageUtil.success("success",all);
    }



    @ApiOperation("insert")
    @GetMapping("insert")
    public Message insert(Category record) throws  Exception{



        int insert = categoryService.insert(record);

        return MessageUtil.success("success",insert);

    //aaa
    }




    @ApiOperation("findcategorybyname")
    @GetMapping("findcategorybyname")
    public Message findcategorybyname(String name) throws  Exception {


            CategoryExtend findcategorybyname = categoryService.findcategorybyname(name);
        if(findcategorybyname==null) {
            Category findcategorybynamedouble = categoryService.findcategorybynamedouble(name);


            return MessageUtil.success("success", findcategorybynamedouble);

        }


        return MessageUtil.success("success", findcategorybyname);
    }



    @PostMapping("batchDelete")
    @ApiOperation("批量删除分类信息")
    public Message batchDelete(@NotNull(message = "ids不能为空") long[] ids) throws Exception{
        categoryService.batchDelete(ids);
        return MessageUtil.success("批量删除成功");
    }
    //a
}



