package com.ckdpharm.homepage.dao.common;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao {
    @Autowired
    public DSLContext dao;
}
