package com.homae.service;

import com.homae.domain.RoomType;
import com.homae.dto.RoomTypeDto;
import com.homae.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 서비스: 핵심 비즈니스 로직을 처리합니다.
 * 엔티티를 DTO로 변환하는 책임도 가집니다.
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;

    public List<RoomTypeDto.SummaryResponse> getAllRoomTypes() {
        return roomTypeRepository.findAll().stream()
                .map(this::convertToSummaryResponse)
                .collect(Collectors.toList());
    }

    private RoomTypeDto.SummaryResponse convertToSummaryResponse(RoomType roomType) {
        // 엔티티를 DTO로 변환
        return RoomTypeDto.SummaryResponse.builder()
                .roomTypeId(roomType.getId())
                .name(roomType.getName())
                .occupancy(RoomTypeDto.SummaryResponse.Occupancy.builder()
                        .standard(roomType.getStandardOccupancy())
                        .max(roomType.getMaxOccupancy())
                        .build())
                .defaultPrice(roomType.getDefaultPrice().getAmount())
                .physicalRoomCount(0) // TODO: 실제 객실 수 카운트 로직 추가 필요
                .isActive(roomType.isActive())
                .build();
    }
}
