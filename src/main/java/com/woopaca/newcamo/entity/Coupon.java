package com.woopaca.newcamo.entity;

import com.woopaca.newcamo.entity.cafe.Cafe;
import lombok.AccessLevel;
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
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long id;
    private int couponStampsNumber;
    private String couponDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_id")
    private Cafe cafe;

    public static Coupon of(User user, Cafe cafe) {
        Coupon coupon = new Coupon();
        coupon.user = user;
        coupon.cafe = cafe;
        user.getCoupons().add(coupon);
        coupon.updateCouponDate();
        return coupon;
    }

    public void updateCouponStampsNumber(int stampsNumber) {
        this.couponStampsNumber += stampsNumber;
    }

    public void updateCouponDate() {
        this.couponDate = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
