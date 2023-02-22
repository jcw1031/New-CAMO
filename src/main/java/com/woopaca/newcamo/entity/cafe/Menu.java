package com.woopaca.newcamo.entity.cafe;

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
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long id;
    private String menuName;
    private int menuPrice;
    private String menuIntroduction;
    private String menuImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_id")
    private Cafe cafe;

    @Builder
    public Menu(String menuName, int menuPrice, String menuIntroduction, String menuImage) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuIntroduction = menuIntroduction;
        this.menuImage = menuImage;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
        cafe.getMenus().add(this);
    }
}
