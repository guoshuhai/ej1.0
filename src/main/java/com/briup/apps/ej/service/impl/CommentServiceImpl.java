package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.CommentExample;
import com.briup.apps.ej.bean.extend.CommentExtend;
import com.briup.apps.ej.dao.CommentMapper;
import com.briup.apps.ej.dao.extend.CommentExtendMapper;
import com.briup.apps.ej.service.CommentService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    CommentExtendMapper commentExtendMapper;
    @Resource
    private CommentMapper commentMapper;

    @Override
    public long countByExample(CommentExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(CommentExample example) { return 0; }


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
    public int insert(Comment record) throws Exception{
        return commentMapper.insert(record);
    }

    @Override
    public int insertSelective(Comment record) { return 0; }

    @Override
    public List<Comment> selectByExample(CommentExample example) { return null; }

    @Override
    public Comment selectByPrimaryKey(Long id) throws Exception{
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Comment record, CommentExample example) { return 0; }

    @Override
    public int updateByExample(Comment record, CommentExample example) { return 0; }

    @Override
    public int updateByPrimaryKeySelective(Comment record) { return 0; }


    @Override
    public int updateByPrimaryKey(Comment record)throws Exception{

        return commentMapper.updateByPrimaryKey(record);
    }

    @Override
    public void saveOrUpdate(Comment comment) throws Exception {
        if (comment.getId() == null) {
            commentMapper.insert(comment);
        } else {
            commentMapper.updateByPrimaryKey(comment);
        }
    }

    //模糊查询
    @Override
    public List<Comment> query(Comment comment)throws Exception {
        return commentMapper.query(comment);
    }

    @Override
    public List<CommentExtend> selectAll(Long id)throws Exception {

        return commentExtendMapper.selectAll(id);
    }

    @Override
    public List<Comment> findAllcomment()throws Exception {
        return commentMapper.findAllcomment();
    }
}
