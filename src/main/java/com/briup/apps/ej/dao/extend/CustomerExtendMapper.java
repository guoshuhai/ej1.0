package com.briup.apps.ej.dao.extend;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.extend.CustomerExtend;

import java.util.List;

public interface CustomerExtendMapper {

        List<CustomerExtend> findAddressById(Long id);

}
