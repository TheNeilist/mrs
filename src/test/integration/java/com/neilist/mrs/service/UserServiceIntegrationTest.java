package com.neilist.mrs.service;

import com.neilist.mrs.MrsApplication;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = MrsApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Ignore
    @Test
    public void testUserService_saveToUserService() {
//        UserCommand user = new UserCommand();
//        user.setEmail("test@example.com");
//        user.setUsername("test@example.com");
//        user.setFirstName("firstname");
//        user.setLastName("lastname");
//        user.setPassword("password");
//        user.setRoles(new HashSet<String>(Arrays.asList("USER")));
//        user.setActive(true);

//        System.out.println(user);

//        userService.saveToUserService(user);
    }

}
