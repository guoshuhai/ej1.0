package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.CommentExample;
import com.briup.apps.ej.dao.CommentMapper;
import com.briup.apps.ej.service.CommentService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public long countByExample(CommentExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(CommentExample example) {
        return 0;
    }

    public int deleteByPrimaryKey(Long id) throws Exception {
        Comment comment=commentMapper.selectByPrimaryKey(id);
        if(comment==null){
            throw new Exception("要删除评论不存在");
        }else {
            commentMapper.deleteByPrimaryKey(id);
        }

        return 0;
    }



    @Override
    public int insert(Comment record) {
        return commentMapper.insert(record);
    }

    @Override
    public int insertSelective(Comment record) {
        return 0;
    }

    @Override
    public List<Comment> selectByExample(CommentExample example) {
        return null;
    }

    @Override
    public Comment selectByPrimaryKey(Long id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Comment record, CommentExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Comment record, CommentExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Comment record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Comment record) {
        return commentMapper.updateByPrimaryKey(record);
    }
}
