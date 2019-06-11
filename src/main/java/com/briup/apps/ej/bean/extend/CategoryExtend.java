package com.briup.apps.ej.bean.extend;

import com.briup.apps.ej.bean.Category;

import java.util.List;

public class CategoryExtend extends Category {

    public List<Category> getChildern() {
        return childern;
    }

    public void setChildern(List<Category> childern) {
        this.childern = childern;
    }

    private List<Category> childern;

}
//a