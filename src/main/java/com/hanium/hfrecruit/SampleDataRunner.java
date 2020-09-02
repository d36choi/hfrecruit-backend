package com.hanium.hfrecruit;

import com.hanium.hfrecruit.domain.application.Application;
import com.hanium.hfrecruit.domain.application.ApplicationRepository;
import com.hanium.hfrecruit.domain.recruit.Recruit;
import com.hanium.hfrecruit.domain.recruit.RecruitRepository;
import com.hanium.hfrecruit.domain.spec.PersonalSpec;
import com.hanium.hfrecruit.domain.spec.PersonalSpecRepository;
import com.hanium.hfrecruit.domain.spec.Spec;
import com.hanium.hfrecruit.domain.spec.SpecRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SampleDataRunner implements CommandLineRunner {

    private final RecruitRepository recruitRepository;
    private final ApplicationRepository applicationRepository;
    private final SpecRepository specRepository;
    private final PersonalSpecRepository personalSpecRepository;

    @Autowired
    public SampleDataRunner(RecruitRepository recruitRepository, ApplicationRepository applicationRepository, SpecRepository specRepository, PersonalSpecRepository personalSpecRepository) {
        this.recruitRepository = recruitRepository;
        this.applicationRepository = applicationRepository;
        this.specRepository = specRepository;
        this.personalSpecRepository = personalSpecRepository;
    }


    @Override
    public void run(String... args) throws Exception {
         Recruit recruitSample = Recruit.builder()
                 .recruitTitle("지원서1")
                 .startDate("20200811")
                 .closedDate("20200911")
                 .recruitContent("안녕하세요 abc회사입니다. 이번 지원에 어쩌구")
                 .closedBit(0)
                 .question1("회사 지원동기는?")
                 .question2("대학교 생활 동안 가장 성취감 느낀 일은?")
                 .question3("회사에 오면 하고 싶은 일은?")
                 .build();
        recruitRepository.save(recruitSample);
        Application applicationSample = Application.builder()
                .militaryService("군필")
                .educationLevel("대학졸업")
                .question1("저는 잘할자신이 있어요")
                .question2("스펙좋아요")
                .question3("꼭 뽑아주세요")
                .bit(0)
                .recruit(recruitSample)
                .build();
        applicationRepository.save(applicationSample);
        Spec specSample = Spec.builder()
                .specName("TOEIC")
                .institution("ACTFL")
                .build();
        specRepository.save(specSample);
        PersonalSpec personalSpecSample = PersonalSpec.builder()
                .spec(specSample)
                .score("900")
                .authDate("20200405")
                .certifiedDate("20210805")
                .build();
        personalSpecRepository.save(personalSpecSample);
    }


}