package com.foameraserblue.carecat.web.dto.marker

import com.sun.jdi.DoubleValue
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(value = "인접한 마커 리스트 요청")
data class AdjMarkerRequestDto(

    @ApiModelProperty(value = "위도", dataType = "Double", required = true, example = "37.557527")
    val lat: Double,
    @ApiModelProperty(value = "경도", dataType = "Double", required = true, example = "126.9222782")
    val lng: Double,
    @ApiModelProperty(value = "줌 사이즈", dataType = "Int", required = true, example = "16")
    val zoom: Int,
    @ApiModelProperty(value = "유저 핸드폰 세로길이", dataType = "Double", required = true, example = "8.24")
    val userPhoneLength: Double

)
