package com.itheima.dao;

import com.itheima.daomain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {

    @Select("select * from member where id =#{id}")
    public Member findBymemberId(String id);
}
