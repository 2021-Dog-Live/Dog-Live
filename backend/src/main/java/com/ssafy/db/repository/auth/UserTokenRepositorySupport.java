package com.ssafy.db.repository.auth;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserTokenRepositorySupport {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

}
