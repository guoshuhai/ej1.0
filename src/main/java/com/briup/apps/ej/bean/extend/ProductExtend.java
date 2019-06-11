package com.briup.apps.ej.bean.extend;

import com.briup.apps.ej.bean.Category;
import com.briup.apps.ej.bean.Product;

public class ProductExtend extends Product {

    private Category category_id;

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }
}


