package com.briup.apps.ej.web.controller;


import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.extend.CommentExtend;
import com.briup.apps.ej.service.CommentService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired   //自动注入
    private CommentService commentService;



    @ApiOperation("模糊查询")
    @GetMapping("query")
    public Message query(Comment comment){
        List<Comment> list = commentService.query(comment);
        return MessageUtil.success("success",list);
    }
    @ApiOperation("查询所有评论信息")
    @GetMapping("findAllcomment")
    public Message findAllcomment(){
        List<Comment> list = commentService.findAllcomment();
        return MessageUtil.success("success",list);
    }


    @ApiOperation("通过ID查询携带订单信息的评论")
    @GetMapping("selectAllById")
    public Message selectAll(Long id) {
        List<CommentExtend> list=commentService.selectAll(id);
        return MessageUtil.success("sucess",list);

    }

    @ApiOperation("通过主键查询")
    @GetMapping("selectById")
    public Message selectById(
            @ApiParam(value = "主键",required = true)
            @RequestParam(value = "id")long id){
        Comment comment=commentService.selectByPrimaryKey(id);
        return MessageUtil.success("success",comment);
    }
    @ApiOperation("通过id删除信息")
    @GetMapping("deleteById")
    public Message deleteById(@ApiParam(value = "主键",required = true) @RequestParam("id") Long id){
        try {
            commentService.deleteByPrimaryKey(id);
            return MessageUtil.success("删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return MessageUtil.error(e.getMessage());
        }
    }
    @ApiOperation("添加评论信息")
    @PostMapping("insert")
    public Message insert(Comment record){

        int insert=commentService.insert(record);
        return MessageUtil.success("success",insert);
    }

    @ApiOperation("更新评论信息")
    @GetMapping("update")
    public Message update(Comment record){

        int update=commentService.updateByPrimaryKey(record);
        return MessageUtil.success("success",update);
    }




}
