package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.bean.ProductExample;
import com.briup.apps.ej.bean.extend.ProductExtend;
import com.briup.apps.ej.dao.ProductMapper;
import com.briup.apps.ej.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.briup.apps.ej.dao.extend.ProductExtendMapper;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;
    @Resource
    private ProductExtendMapper productExtendMapper;

    @Override
    public List<Product> query(Product product) {
        // 创建空模板
        ProductExample example = new ProductExample();
        // 在模板中添加条件
        if (product.getName() != null) {
            example
                    .createCriteria()
                    .andNameLike("%" + product.getName() + "%");
        }

        return productMapper.selectByExample(example);
    }

    @Override
    public List<Product> findAll() {
        ProductExample example = new ProductExample();

        return productMapper.selectByExample(example);
    }

    @Override
    public Product findById(long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Product product) throws Exception {
        if (product.getId() == null) {
            // 初始化属性
            product.setStatus("正常");
            productMapper.insert(product);
        } else {
            productMapper.updateByPrimaryKey(product);
        }
    }

    @Override
    public void insert(Product product) throws Exception {
        if (product.getId() == null) {
            // 初始化属性
            product.setStatus("正常");
            productMapper.insert(product);
        } else {
            productMapper.insert(product);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        Product product = productMapper.selectByPrimaryKey(id);
        if (product == null) {
            throw new Exception("要删除的用户不存在");
        } else {
            productMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public ProductExtend selectByPrimaryKeyw(Long id) {
        return productExtendMapper.selectByPrimaryKeyw(id);
    }
}
