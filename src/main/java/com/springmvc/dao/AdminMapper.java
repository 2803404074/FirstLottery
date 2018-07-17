package com.springmvc.dao;

import com.springmvc.pojo.Admin;

public interface AdminMapper {
    Admin selectByPrimaryKey(int id);
}