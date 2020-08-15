package com.hanium.hfrecruit.repository;

import com.hanium.hfrecruit.HfrecruitApplicationTests;
import com.hanium.hfrecruit.domain.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserRepositoryTest extends HfrecruitApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();

        user.setUserId("test02");
        user.setUserPw("test0202");
        user.setUsername("testuser02");
        user.setCollege("test");
        user.setHighschool("test");
        user.setBirth("980903");
        user.setGender(0);

        User newUser = userRepository.save(user);

        System.out.println("newUser: " + newUser);


    }
}
