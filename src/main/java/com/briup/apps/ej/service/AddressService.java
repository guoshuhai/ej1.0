package com.briup.apps.ej.service;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.AddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressService {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_address
     *
     * @mbg.generated Mon Jun 10 11:21:59 CST 2019
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_address
     *
     * @mbg.generated Mon Jun 10 11:21:59 CST 2019
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_address
     *
     * @mbg.generated Mon Jun 10 11:21:59 CST 2019
     */
    int deleteByPrimaryKey(Long id) throws  Exception;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_address
     *
     * @mbg.generated Mon Jun 10 11:21:59 CST 2019
     */
    int insert(Address record) throws  Exception;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_address
     *
     * @mbg.generated Mon Jun 10 11:21:59 CST 2019
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_address
     *
     * @mbg.generated Mon Jun 10 11:21:59 CST 2019
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_address
     *
     * @mbg.generated Mon Jun 10 11:21:59 CST 2019
     */
    Address selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_address
     *
     * @mbg.generated Mon Jun 10 11:21:59 CST 2019
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_address
     *
     * @mbg.generated Mon Jun 10 11:21:59 CST 2019
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_address
     *
     * @mbg.generated Mon Jun 10 11:21:59 CST 2019
     */

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_address
     *
     * @mbg.generated Mon Jun 10 11:21:59 CST 2019
     */
    int updateByPrimaryKey(Address record) throws  Exception;
    List<Address> query(Address address);

}
