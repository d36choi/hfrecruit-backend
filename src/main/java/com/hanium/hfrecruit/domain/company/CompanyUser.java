package com.hanium.hfrecruit.domain.company;

import com.hanium.hfrecruit.domain.recruit.Recruit;
import com.hanium.hfrecruit.domain.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "recruits")
@Entity
public class CompanyUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long companyUserId;

    @Column(nullable = false)
    private Integer companyUserCode;

    @Column(nullable = false)
    private String companyUserEmail;

    @ManyToOne
    @JoinColumn(name = "company_no")
    private CompanyInfo companyInfo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "companyUser")
    private List<Recruit> recruits;

    public void update(Integer companyUserCode) {
        this.companyUserCode = companyUserCode;
    }
}
