package com.woopaca.newcamo.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Employment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employment_id")
    private Long id;
    private String employmentDate;
    private String employmentTerm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_id")
    private Cafe cafe;

    @Builder
    public Employment(String employmentDate, String employmentTerm) {
        this.employmentDate = employmentDate;
        this.employmentTerm = employmentTerm;
    }

    public void hire(User user, Cafe cafe) {
        this.employee = user;
        this.cafe = cafe;
        employee.getEmployers().add(this);
        cafe.getEmployees().add(this);
    }
}
