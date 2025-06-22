package com.homae.repository;

import com.homae.domain.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 리포지토리: 데이터베이스와의 통신을 담당합니다.
 */
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
}
