package com.briup.apps.ej.web.controller;


import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.service.CommentService;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment")
public class CommentController {

    @Autowired   //自动注入
    private CommentService commentService;

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
    @GetMapping("insert")
    public Message insert(Comment record){

        int insert=commentService.insert(record);
        return MessageUtil.success("success",insert);
    }

    @ApiOperation("更新评论信息")
    @GetMapping("update")
    public Message updateByExampleSelective(Comment record){

        int updateByExampleSelective=commentService.insert(record);
        return MessageUtil.success("success",updateByExampleSelective);
    }

}
