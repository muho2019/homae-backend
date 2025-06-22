package com.homae.controller;

import com.homae.dto.RoomTypeDto;
import com.homae.service.RoomTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 컨트롤러: 외부의 API 요청을 받고 응답하는 창구 역할을 합니다.
 */
@RestController
@RequestMapping("/api/v1/room-types")
@RequiredArgsConstructor
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    @GetMapping
    public ResponseEntity<List<RoomTypeDto.SummaryResponse>> getRoomTypeList() {
        List<RoomTypeDto.SummaryResponse> roomTypes = roomTypeService.getAllRoomTypes();
        return ResponseEntity.ok(roomTypes);
    }
}
