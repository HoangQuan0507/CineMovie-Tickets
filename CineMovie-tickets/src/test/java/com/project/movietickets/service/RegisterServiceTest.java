package com.project.movietickets.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class RegisterServiceTest {

    @Autowired
    private RegisterService service;

    @Test
    public void testRegisterServiceWillCallUserRepository(){
        var result = service.registerUser(
                "demo",
                "password",
                "fullname",
                "email@gmail.com",
                "0859292357",
                "HaNoi",
                "CGV",
                true,
                "2020-02-02"
        );

        assertNotNull(result);
    }
}
