package com.hanium.hfrecruit.controller;

import com.hanium.hfrecruit.auth.dto.SessionUser;
import com.hanium.hfrecruit.domain.company.CompanyInfo;
import com.hanium.hfrecruit.domain.company.CompanyInfoRepository;
import com.hanium.hfrecruit.domain.recruit.Recruit;
import com.hanium.hfrecruit.domain.user.User;
import com.hanium.hfrecruit.domain.user.UserRepository;
import com.hanium.hfrecruit.dto.ApplicationSaveRequestDto;
import com.hanium.hfrecruit.dto.CompanyInfoDto;
import com.hanium.hfrecruit.dto.CompanyUserDto;
import com.hanium.hfrecruit.service.CompanyInfoService;
import com.hanium.hfrecruit.service.CompanyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class CompanyUserController {
    private final CompanyUserService companyUserService;
    private final CompanyInfoService companyInfoService;
    private final CompanyInfoRepository companyInfoRepository;
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @GetMapping("/companyInfo")
    public String companyInfo(){
        return "companyInfo";
    }

    @GetMapping("/companyUser")
    public String companyUser(Model model) {
        model.addAttribute("companyInfo", companyInfoRepository.findAll());
        return "companyUser";
    }

    @ResponseBody
    @PostMapping("/companyUser/save/{companyNo}")
    public Long CompanyUserSave(@SessionAttribute("user") SessionUser sessionUser, @RequestBody CompanyUserDto companyUserDto, @PathVariable Long companyNo) {
 //       User loginUser = userRepository.findByEmail(sessionUser.getEmail());
        CompanyInfo companyInfo = companyInfoRepository.findByCompanyNo(companyNo);
        return companyUserService.save(companyUserDto, companyInfo);
    }

    @ResponseBody
    @PostMapping("/companyInfo/save")
    public Long companyInfoSave(@RequestBody CompanyInfoDto companyInfoDto){
        return companyInfoService.save(companyInfoDto);
    }

}