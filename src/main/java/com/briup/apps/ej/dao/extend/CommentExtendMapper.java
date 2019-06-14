package com.briup.apps.ej.dao.extend;
import com.briup.apps.ej.bean.extend.CommentExtend;

import java.util.List;
public interface CommentExtendMapper {

    List<CommentExtend> selectAll(long id)throws Exception;

}
