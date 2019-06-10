package com.briup.apps.ej.web.controller;

import com.briup.apps.ej.bean.Waiter;
import com.briup.apps.ej.service.WaiterSercive;
import com.briup.apps.ej.utils.Message;
import com.briup.apps.ej.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("waiter")
public class WaiterController {

    @Autowired
    private WaiterSercive waiterSercive;

        @GetMapping("findAllwaiter")
        public Message findAllwaiter(){

            List<Waiter> allwaiter = waiterSercive.findAllwaiter();

            return MessageUtil.success("success",allwaiter);

        }


    }

