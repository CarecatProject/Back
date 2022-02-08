package com.foameraserblue.carecat.web.controller

import com.foameraserblue.carecat.web.dto.marker.AdjMarkerRequestDto
import com.foameraserblue.carecat.web.dto.marker.MarkerRequestDto
import com.foameraserblue.carecat.web.service.MarkerService
import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/marker")
@Api(value = "Marker Api 컨트롤러")
class MarkerController(val markerService: MarkerService) {

    //    @GetMapping("/adjmarker")
//    fun adjMarker(adjMarkerRequestDto: AdjMarkerRequestDto): List<AdjMarkerResponseDto> {
//
//    }
    @PostMapping("/marker")
    fun registerMarker(markerRequestDto: MarkerRequestDto) {
        markerService.registerMarker(markerRequestDto)

    }


}