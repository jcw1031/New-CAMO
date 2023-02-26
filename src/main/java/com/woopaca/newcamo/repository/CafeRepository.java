package com.woopaca.newcamo.repository;

import com.woopaca.newcamo.entity.cafe.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Long> {
}
