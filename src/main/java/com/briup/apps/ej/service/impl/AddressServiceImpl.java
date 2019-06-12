package com.briup.apps.ej.service.impl;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.AddressExample;
import com.briup.apps.ej.dao.AddressMapper;
import com.briup.apps.ej.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressMapper addressMapper;






    @Override
    public int deleteByPrimaryKey(Long id) throws Exception {
        return addressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Address record) throws  Exception{
        return addressMapper.insert(record)  ;
    }



    @Override
    public Address selectByPrimaryKey(Long id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Address> query(Address address) {
        return addressMapper.query(address);
    }




    @Override
    public int updateByPrimaryKey(Address record) throws  Exception {
        return addressMapper.updateByPrimaryKey(record);
    }
}
