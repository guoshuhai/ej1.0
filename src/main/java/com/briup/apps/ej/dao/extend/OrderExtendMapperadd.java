package com.briup.apps.ej.dao.extend;

import com.briup.apps.ej.bean.VM.OrderVM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderExtendMapperadd {
    List<OrderVM> queryBasic(
            @Param("customerId") Long customerId,
            @Param("waiterId") Long waiterId
    );

}


