package com.woopaca.newcamo.entity;

import com.woopaca.newcamo.controller.dto.SignUpRequestDto;
import com.woopaca.newcamo.entity.cafe.Cafe;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    private String phone;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    @OneToMany(mappedBy = "owner")
    private List<Cafe> cafes = new ArrayList<>();

    @OneToMany(mappedBy = "writer")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Coupon> coupons = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<Employment> employers = new ArrayList<>();

    @Builder
    public User(String email, String password, String name, String phone) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public static User from(final SignUpRequestDto signUpRequestDto) {
        return User.builder()
                .email(signUpRequestDto.getEmail())
                .password(BCrypt.hashpw(signUpRequestDto.getPassword(), BCrypt.gensalt()))
                .name(signUpRequestDto.getName())
                .phone(signUpRequestDto.getPhone())
                .build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
