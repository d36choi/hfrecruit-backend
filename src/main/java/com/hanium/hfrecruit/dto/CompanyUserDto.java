package com.hanium.hfrecruit.dto;

import com.hanium.hfrecruit.domain.company.CompanyInfo;
import com.hanium.hfrecruit.domain.company.CompanyUser;
import com.hanium.hfrecruit.domain.user.User;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CompanyUserDto {
    private Long companyUserId;
    private Integer companyUserCode;
    private CompanyInfo companyInfo;
    private String companyUserEmail;

    @Builder
    public CompanyUserDto(CompanyUser entity){
        this.companyUserId = entity.getCompanyUserId();
        this.companyUserCode = entity.getCompanyUserCode();
        this.companyInfo = entity.getCompanyInfo();
        this.companyUserEmail = entity.getCompanyUserEmail();
//        this.user = entity.getUser();
    }

    @Builder
    public CompanyUserDto(Integer companyUserCode, CompanyInfo companyInfo){
        this.companyUserCode = companyUserCode;
        this.companyInfo = companyInfo;
    }

    public CompanyUser toEntity(CompanyInfo companyInfo, User user){
        return CompanyUser.builder()
                .companyUserId(companyUserId)
                .companyUserCode(companyUserCode)
                .companyInfo(companyInfo)
                .companyUserEmail(user.getEmail())
                //.user(user)
                .build();
    }
}
