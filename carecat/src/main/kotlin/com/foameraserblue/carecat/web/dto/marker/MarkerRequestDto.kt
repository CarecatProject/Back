package com.foameraserblue.carecat.web.dto.marker

import com.foameraserblue.carecat.web.entitiy.Marker.Marker
import com.foameraserblue.carecat.web.entitiy.Marker.MarkerDetails
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty


@ApiModel(value = "마커 생성 요청")
data class MarkerRequestDto(

    @ApiModelProperty(value = "위도", dataType = "Double", required = true, example = "37.557527")
    val lat: Double,
    @ApiModelProperty(value = "경도", dataType = "Double", required = true, example = "126.9222782")
    val lng: Double,
    @ApiModelProperty(value = "주소(구글맵 변수명 사용)", dataType = "String", required = true, example = "서울특별시 마포구 동교동 165")
    val street: String
) {
    fun toEntity(): Marker {
        val markerDetails: MarkerDetails = (MarkerDetails(street = street))
        return Marker(lat = lat, lng = lng, markerDetails = markerDetails)
    }
}