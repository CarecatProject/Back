package com.foameraserblue.carecat.web.service

import com.foameraserblue.carecat.web.dto.marker.AdjMarkerRequestDto
import com.foameraserblue.carecat.web.dto.marker.AdjMarkerResponseDto
import com.foameraserblue.carecat.web.dto.marker.MarkerRequestDto
import com.foameraserblue.carecat.web.entitiy.Marker.Marker
import com.foameraserblue.carecat.web.repository.marker.MarkerRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional


@Service
class MarkerService(val markerRepository: MarkerRepository) {

//    fun adjMarker(adjMarkerRequestDto: AdjMarkerRequestDto): List<AdjMarkerResponseDto> {
//
//    }

    /**
     * Marker Api를 통해 request가 올시, 새로운 Marker을 생성한다
     * @param markerRequestDto 사용자가 지정한 마커의 위도, 경도 값
     */
    @Transactional
    fun registerMarker(markerRequestDto: MarkerRequestDto){
        val marker: Marker = markerRequestDto.toEntity()

        markerRepository.save(marker)

    }
}