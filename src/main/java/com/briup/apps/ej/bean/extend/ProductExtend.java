package com.briup.apps.ej.bean.extend;

import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.bean.Product;

public class ProductExtend extends Product {

    private Category categorys;

    public Category getCategorys() {
        return categorys;
    }

    public void setCategorys(Category categorys) {
        this.categorys = categorys;
    }
}




