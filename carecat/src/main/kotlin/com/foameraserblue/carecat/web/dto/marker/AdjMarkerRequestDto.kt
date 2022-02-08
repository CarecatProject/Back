package com.foameraserblue.carecat.web.dto.marker

import com.sun.jdi.DoubleValue
import io.swagger.annotations.ApiModelProperty

data class AdjMarkerRequestDto(

    @ApiModelProperty(value = "위도", dataType = "Double", required = true, example = "37.557527")
    val lat: Double,
    @ApiModelProperty(value = "경도", dataType = "Double", required = true, example = "126.9222782")
    val lng: Double,
    @ApiModelProperty(value = "줌 사이즈", dataType = "Int", required = true, example = "16")
    val zoom: Int
)
