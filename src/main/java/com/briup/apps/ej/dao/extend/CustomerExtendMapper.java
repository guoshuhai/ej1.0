package com.briup.apps.ej.dao.extend;

import com.briup.apps.ej.bean.Address;

import java.util.List;

public interface CustomerExtendMapper {

        List<Address> findAddressById(Long id);

}
