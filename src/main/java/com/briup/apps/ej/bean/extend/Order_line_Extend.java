package com.briup.apps.ej.bean.extend;

import com.briup.apps.ej.bean.Order;
import com.briup.apps.ej.bean.Order_line;
import com.briup.apps.ej.bean.Product;

public class Order_line_Extend  extends Order_line {
    private Product product;

    private Order  order;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
