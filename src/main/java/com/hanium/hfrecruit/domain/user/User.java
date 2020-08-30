package com.hanium.hfrecruit.domain.user;

import com.hanium.hfrecruit.domain.spec.PersonalSpec;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userNo;

    @Column(nullable = true)
    private String userId;

    @Column(nullable = true)
    private String userPw;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private String college;

    @Column(nullable = true)
    private String highschool;

    @Column(nullable = true)
    private String birth;

    @Column(nullable = true)
    private Integer gender;

    @Enumerated(EnumType.STRING) // (1)
    @Column(nullable = false)
    private Role role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<PersonalSpec> personalSpecs;

    @Builder
    public User(String name, String email, Role role) {
        this.username = name;
        this.email = email;
        this.role = role;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }

}
