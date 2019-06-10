package com.briup.apps.ej.service.impl;
import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.bean.CategoryExample;
import com.briup.apps.ej.dao.CategoryMapper;
import com.briup.apps.ej.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl  implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public long countByExample(CategoryExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(CategoryExample example)  {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Long id) throws  Exception {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Category record) throws  Exception {
        return categoryMapper.insert(record);
    }

    @Override
    public int insertSelective(Category record) {
        return 0;
    }

    @Override
    public List<Category> selectByExample(CategoryExample example) {
        return null;
    }

    @Override
    public Category selectByPrimaryKey(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Category record, CategoryExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Category record, CategoryExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Category record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(Category record) throws  Exception {
        return categoryMapper.updateByPrimaryKey(record);
    }
}
