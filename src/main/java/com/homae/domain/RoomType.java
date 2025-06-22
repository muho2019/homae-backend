package com.homae.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 엔티티(Entity): RoomType 애그리거트 루트
 * 우리 비즈니스의 핵심 자산인 '객실 타입'을 정의합니다.
 */
@Entity
@Table(name = "room_types")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomType  extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_type_id")
    private Long id;

    private Long hotelId;
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int standardOccupancy;
    private int maxOccupancy;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "default_price", precision = 12, scale = 2))
    })
    private Money defaultPrice;

    @Column(columnDefinition = "TEXT")
    private String amenities;

    private boolean isActive;
}
