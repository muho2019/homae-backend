package com.homae.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * DTO: API 응답을 위한 데이터 전송 객체
 * 화면에 필요한 데이터만 가공하여 전달하는 역할을 합니다.
 */
public class RoomTypeDto {

    @Getter
    @Builder
    public static class SummaryResponse {
        private Long roomTypeId;
        private String name;
        private Occupancy occupancy;
        private BigDecimal defaultPrice;
        private int physicalRoomCount;
        private boolean isActive;

        @Getter
        @Builder
        public static class Occupancy {
            private int standard;
            private int max;
        }
    }
}
