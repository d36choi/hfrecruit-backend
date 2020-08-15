package com.hanium.hfrecruit.repository;

import com.hanium.hfrecruit.HfrecruitApplicationTests;
import com.hanium.hfrecruit.domain.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest extends HfrecruitApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();

        user.setUserId("test03");
        user.setUserPw("test0303");
        user.setUsername("testuser03");
        user.setCollege("test3");
        user.setHighschool("test3");
        user.setBirth("980903");
        user.setGender(1);

        User newUser = userRepository.save(user);

        System.out.println("newUser: " + newUser);

    }

    @Test
    @Transactional
    public void read(){
        Optional<User> user = userRepository.findByUserNo((1L));

        user.ifPresent(user1 ->{
            System.out.println("newUser : " + user1);
        });
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findByUserNo(2L);

        user.ifPresent(user1 -> {
            user1.setUsername("updated_user");

            userRepository.save(user1);
        });

    }

    @Test
    public void delete(){
        Optional<User> user = userRepository.findByUserNo(1L);

        assertTrue(user.isPresent());

        user.ifPresent(user1 -> {
            userRepository.delete(user1);   //delete()는 반환형이 x
        });

        Optional<User> deletedUser = userRepository.findById(1L);

        assertFalse(deletedUser.isPresent());
    }
}
