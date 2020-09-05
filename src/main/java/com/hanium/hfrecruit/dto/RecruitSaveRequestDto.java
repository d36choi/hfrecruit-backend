package com.hanium.hfrecruit.dto;

import com.hanium.hfrecruit.domain.recruit.Recruit;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class RecruitSaveRequestDto {
    private String recruitTitle;
    private String recruitContent;
    private Timestamp startDate;
    private Timestamp closedDate;
    private String question1;
    private String question2;
    private String question3;
    private String question4;
    private String question5;

    @Builder
    public RecruitSaveRequestDto(String recruitTitle, String recruitContent, Timestamp startDate, Timestamp closedDate,
                                 String question1, String question2, String question3, String question4, String question5) {
        this.recruitTitle = recruitTitle;
        this.recruitContent = recruitContent;
        this.startDate = startDate;
        this.closedDate = closedDate;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.question4 = question4;
        this.question5 = question5;
    }

    public Recruit toEntity() {
        return Recruit.builder()
                .recruitTitle(recruitTitle)
                .recruitContent(recruitContent)
                .startDate(startDate)
                .closedDate(closedDate)
                .question1(question1)
                .question2(question2)
                .question3(question3)
                .question4(question4)
                .question5(question5)
                .build();
    }
}