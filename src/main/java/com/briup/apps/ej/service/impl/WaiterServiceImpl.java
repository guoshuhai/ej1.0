package com.briup.apps.ej.service.impl;




import com.briup.apps.ej.bean.Product;
import com.briup.apps.ej.bean.Waiter;
import com.briup.apps.ej.bean.WaiterExample;

import com.briup.apps.ej.dao.WaiterMapper;
import com.briup.apps.ej.service.WaiterService;
import com.briup.apps.ej.utils.MessageUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/waiter")
public class WaiterServiceImpl implements WaiterService {
    @Resource
    private WaiterMapper waiterMapper;

    @Override
    public List<Waiter> query(Waiter waiter) {
        // 创建空模板
        WaiterExample example = new WaiterExample();
        // 在模板中添加条件
        if (waiter.getTelephone() != null) {
            example
                    .createCriteria()
                    .andTelephoneLike("%" + waiter.getTelephone() + "%");
        }

        return waiterMapper.selectByExample(example);
    }
    @Override
    public List<Waiter> findAll() {
        WaiterExample example = new WaiterExample();

        return waiterMapper.selectByExample(example);
    }
    @Override
    public Waiter findById(long id) {
        return waiterMapper.selectByPrimaryKey(id);

}


   @Override
    public void Update(Waiter waiter) throws Exception {
        if (waiter.getId()!= null) {
            Waiter waiter1=waiterMapper.selectByPrimaryKey(waiter.getId());
            // 初始化属性
            if(MessageUtil.success("",waiter1).getData()!=null){
                waiter.setStatus("正常");
                waiterMapper.updateByPrimaryKey(waiter);
            }else {
                throw new Exception("要更新的用户不存在");
            }
        } else {
            throw new Exception("id值不能为空");
        }
    }

    @Override
    public void insert(Waiter waiter) throws Exception {
        if (waiter.getId() == null) {
            waiterMapper.insert(waiter);
        } else {
            throw new Exception("id值必须为空");
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        Waiter waiter = waiterMapper.selectByPrimaryKey(id);
        if (waiter == null) {
            throw new Exception("要删除的用户不存在");
        } else {
            waiterMapper.deleteByPrimaryKey(id);
        }
    }
    @Override
    public void batchDelete(long[] ids) throws Exception {
        for (long id : ids) {
            waiterMapper.deleteByPrimaryKey(id);
        }
    }
}

