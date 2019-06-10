package com.briup.apps.ej.bean.extend;

import com.briup.apps.ej.bean.Comment;
import com.briup.apps.ej.bean.Order;

public class CommentExtend extends Order {

    private Comment order;
    public  Comment getOrder() { return order;}

    public  void setOrder(Comment order){
        this.order = order;
    }

}
