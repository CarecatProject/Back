package com.foameraserblue.carecat.web.repository.marker

import com.foameraserblue.carecat.web.dto.marker.AdjMarkerResponseDto

interface MarkerRepositoryCustom {
    fun adjMarker(lat: Double, lng: Double, distance: Double): List<AdjMarkerResponseDto>
}