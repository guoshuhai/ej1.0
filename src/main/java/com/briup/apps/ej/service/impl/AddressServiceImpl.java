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
    public long countByExample(AddressExample example) {
        return addressMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AddressExample example) {
        return addressMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) throws Exception {
        return addressMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Address record) throws  Exception{
        return addressMapper.insert(record)  ;
    }

    @Override
    public int insertSelective(Address record) {
        return insertSelective(record);
    }

    @Override
    public List<Address> selectByExample(AddressExample example) {
        return addressMapper.selectByExample(example);
    }

    @Override
    public Address selectByPrimaryKey(Long id) {
        return selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Address record, AddressExample example) {
        return addressMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Address record, AddressExample example) {
        return addressMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Address record) {
        return addressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Address record) throws  Exception {
        return addressMapper.updateByPrimaryKey(record);
    }
}
