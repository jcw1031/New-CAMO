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
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cafe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cafe_id")
    private Long id;
    private String cafeName;
    private String cafeAddress;
    private String cafePhone;
    private String cafeIntroduction;
    private String cafeReward;
    private String cafeRewardStampsNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User owner;

    @OneToMany(mappedBy = "cafe")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "cafe")
    private List<Employment> employees = new ArrayList<>();

    @OneToMany(mappedBy = "cafe")
    private List<Menu> menus = new ArrayList<>();

    @OneToMany(mappedBy = "cafe")
    private List<Image> images = new ArrayList<>();

    @Builder
    public Cafe(String cafeName, String cafeAddress, String cafePhone, String cafeIntroduction,
                String cafeReward, String cafeRewardStampsNumber) {
        this.cafeName = cafeName;
        this.cafeAddress = cafeAddress;
        this.cafePhone = cafePhone;
        this.cafeIntroduction = cafeIntroduction;
        this.cafeReward = cafeReward;
        this.cafeRewardStampsNumber = cafeRewardStampsNumber;
    }

    public void setOwner(User user) {
        this.owner = user;
        user.getCafes().add(this);
    }
}