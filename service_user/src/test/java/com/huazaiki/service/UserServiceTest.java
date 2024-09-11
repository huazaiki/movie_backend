package com.huazaiki.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UsersService usersService;

    @Test
    public void testListUser() {
        usersService.findAll().forEach(System.out::println);
    }
}
