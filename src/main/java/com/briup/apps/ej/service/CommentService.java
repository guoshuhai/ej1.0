package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.CommentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {

        long countByExample(CommentExample example);
        int deleteByExample(CommentExample example);
        int deleteByPrimaryKey(Long id) throws Exception;
        int insert(Comment record);
        int insertSelective(Comment record);
        List<Comment> selectByExample(CommentExample example);
        Comment selectByPrimaryKey(Long id);
        int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);
        int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);
        int updateByPrimaryKeySelective(Comment record);
        int updateByPrimaryKey(Comment record);
    }

