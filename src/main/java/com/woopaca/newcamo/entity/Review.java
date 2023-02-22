package com.woopaca.newcamo.entity;

import com.woopaca.newcamo.entity.cafe.Cafe;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;
    private String reviewContents;
    private int reviewScore;
    private String reviewDate = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    private String reviewImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_id")
    private Cafe cafe;

    @Builder
    public Review(String reviewContents, int reviewScore, String reviewImage) {
        this.reviewContents = reviewContents;
        this.reviewScore = reviewScore;
        this.reviewImage = reviewImage;
    }

    public void writeReview(User user, Cafe cafe) {
        this.writer = user;
        this.cafe = cafe;
        user.getReviews().add(this);
        cafe.getReviews().add(this);
    }
}
