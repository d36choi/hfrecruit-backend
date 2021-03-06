package com.hanium.hfrecruit.domain.recruit;

import com.hanium.hfrecruit.domain.application.Application;
import com.hanium.hfrecruit.domain.company.CompanyInfo;
import com.hanium.hfrecruit.domain.company.CompanyUser;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString(exclude = "applicationList")
@Entity
public class Recruit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long recruitNo;

    @Column(nullable = false)
    private String recruitTitle;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String recruitContent;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime closedDate;

    private Integer closedBit;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String question1;

    @Column(columnDefinition = "LONGTEXT")
    private String question2;

    @Column(columnDefinition = "LONGTEXT")
    private String question3;

    @Column(columnDefinition = "LONGTEXT")
    private String question4;

    @Column(columnDefinition = "LONGTEXT")
    private String question5;

    @ManyToOne
    @JoinColumn(name = "company_no")
    private CompanyInfo companyInfo;

    @ManyToOne
    @JoinColumn(name = "company_user_id")
    private CompanyUser companyUser;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recruit")
    private List<Application> applicationList;

    /*
    public String getFormattedClosedDate(){
        if(closedDate == null){
            return "";
        }
        return closedDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
    }*/
    public void update(String recruitTitle, String recruitContent, LocalDateTime startDate, LocalDateTime closedDate,
                       String question1, String question2, String question3, String question4, String question5)  {
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

    public void updateBit(int closedBit) {
        this.closedBit = closedBit;
    }

//    @Override
//    public String toString() {
//        return "Recruit{" +
//                "recruitNo=" + recruitNo +
//                ", recruitTitle='" + recruitTitle +
//                ", recruitContent='" + recruitContent +
//                ", startDate='" + startDate +
//                ", closedDate='" + closedDate +
//                ", question1='" + question1 +
//                ", question2='" + question2 +
//                ", question3='" + question3 +
//                ", question4='" + question4 +
//                ", question5='" + question5 +
//                '}';
//    }
}
