package com.briup.apps.ej.bean;

import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotBlank;


public class Comment {

    private Long id;


    private String content;


    private Long commentTime;

    private Long orderId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }


    public Long getCommentTime() {
        return commentTime;
    }


    public void setCommentTime(Long commentTime) {
        this.commentTime = commentTime;
    }


    public Long getOrderId() {
        return orderId;
    }


    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}