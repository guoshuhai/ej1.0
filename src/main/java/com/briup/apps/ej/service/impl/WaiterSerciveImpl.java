package com.briup.apps.ej.service.impl;


import com.briup.apps.ej.bean.Waiter;
import com.briup.apps.ej.dao.WaiterMapper;
import com.briup.apps.ej.service.WaiterSercive;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WaiterSerciveImpl  implements WaiterSercive {
    @Resource
    private WaiterMapper waiterMapper;


    @Override
    public List<Waiter> findAllwaiter() {


        return waiterMapper.findAllwaiter();
    }
}
