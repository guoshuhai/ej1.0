package com.briup.apps.ej.dao;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {

    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int deleteByPrimaryKey(Long id)throws Exception;

    int insert(Comment record)throws Exception;

    Comment selectByPrimaryKey(Long id)throws Exception;

    int updateByPrimaryKey(Comment record)throws Exception;
    //模糊查询
    List<Comment> query( Comment comment)throws Exception;
    //查询所有
    List<Comment> findAllcomment()throws Exception;


}