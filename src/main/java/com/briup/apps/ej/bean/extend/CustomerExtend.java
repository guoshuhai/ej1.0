package com.briup.apps.ej.bean.extend;

import com.briup.apps.ej.bean.Address;
import com.briup.apps.ej.bean.Customer;

import java.util.List;

public class CustomerExtend extends Customer {

    private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}


