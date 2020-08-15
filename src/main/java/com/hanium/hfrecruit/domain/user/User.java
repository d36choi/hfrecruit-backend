package com.hanium.hfrecruit.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private Long userNo;
    private String userId;
    private String userPw;
    private String username;
    private String college;
    private String highschool;
    private String birth;
    private Integer gender;

}
