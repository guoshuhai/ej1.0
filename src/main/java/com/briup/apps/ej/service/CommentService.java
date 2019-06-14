package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.CommentExample;
import com.briup.apps.ej.bean.extend.CommentExtend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {

        long countByExample(CommentExample example);

        int deleteByExample(CommentExample example);

        int insertSelective(Comment record);

        List<Comment> selectByExample(CommentExample example);

        int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

        int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

        int updateByPrimaryKeySelective(Comment record);


        List <Comment>findAllcomment()throws Exception;

        List<CommentExtend> selectAll(Long id)throws Exception;

        Comment selectByPrimaryKey(Long id)throws Exception;

        List <Comment>  query(Comment comment)throws Exception;

        int insert(Comment record)throws Exception;

        int deleteByPrimaryKey(Long id) throws Exception;

        int updateByPrimaryKey(Comment record) throws Exception;

        void saveOrUpdate(Comment comment) throws Exception ;

}

