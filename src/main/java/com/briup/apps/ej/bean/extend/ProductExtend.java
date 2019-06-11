package com.briup.apps.ej.bean.extend;

import com.briup.apps.ej.bean.Product;

public class ProductExtend extends Product {

    private  long category;

    public void setCategory(long category) {
        this.category = category;
    }

    public long getCategory() {
        return category;
    }
}
