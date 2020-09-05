package com.hanium.hfrecruit.controller;

import com.hanium.hfrecruit.auth.dto.SessionUser;
import com.hanium.hfrecruit.domain.user.User;
import com.hanium.hfrecruit.domain.user.UserRepository;
import com.hanium.hfrecruit.dto.UserResponseDto;
import com.hanium.hfrecruit.dto.UserUpdateRequestDto;
import com.hanium.hfrecruit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class OAuthController {
    private final HttpSession httpSession;
    @Autowired
    private UserService userService;
    private final UserRepository userRepository;

    @GetMapping({"", "/home"})
    public String home(Model model) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null) {
            model.addAttribute("userName", user.getName());

        }
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/userInfo")
    public String userInfo(Model model) {
        SessionUser sessionUser = (SessionUser) httpSession.getAttribute("user");

        if(sessionUser != null){
            User user = userRepository.findByEmail(sessionUser.getEmail())
                    .orElseThrow(() -> new NoResultException("erroror"));
            model.addAttribute("userNo", user.getUserNo());
            model.addAttribute("userName", user.getUsername());
        }
        return "userInfo";
    }

    @PutMapping("/userInfo/{userNo}")
    @ResponseBody
    public Long update(@PathVariable Long userNo, @RequestBody UserUpdateRequestDto requestDto){
        return userService.update(userNo, requestDto);
    }

    @GetMapping("/loginFailure")
    public String loginFailure() {
        return "loginFailure";
    }
}