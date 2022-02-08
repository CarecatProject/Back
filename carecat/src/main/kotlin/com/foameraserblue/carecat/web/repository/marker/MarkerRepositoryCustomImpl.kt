package com.foameraserblue.carecat.web.repository.marker

import com.foameraserblue.carecat.web.dto.marker.AdjMarkerResponseDto
import com.foameraserblue.carecat.web.entitiy.Marker.QMarker.marker
import com.querydsl.core.types.Projections
import com.querydsl.core.types.dsl.Expressions
import com.querydsl.core.types.dsl.MathExpressions.*
import com.querydsl.jpa.impl.JPAQueryFactory

class MarkerRepositoryCustomImpl(
    val jpaQueryFactory: JPAQueryFactory
) : MarkerRepositoryCustom {

    /**
     * 사용자가 보고있는 지도의 위도, 경도 중앙값을 받아, 사용자가 보는 줌 사이즈 안에 들어오는
     * 마커를 모두 보여준다.
     *
     * @param lat 사용자 지도의 위도 중앙값
     * @param lng 사용자 지도의 경도 중앙값
     * @param distance 사용자가 보는 줌 사이즈를 km거리로 치환한 값
     *
     * @return [AdjMarkerResponseDto] 리스트
     */
    override fun adjMarker(lat: Double, lng: Double, distance: Int): List<AdjMarkerResponseDto> {
        return jpaQueryFactory
            .select(
                Projections.constructor(
                    AdjMarkerResponseDto::class.java,
                    marker.id,
                    marker.lat,
                    marker.lon
                )
            )
            .from(marker)
            .where(
                (Expressions.asNumber(6371).multiply(
                    acos(
                        cos(radians(Expressions.asNumber(lat)))
                            .multiply(cos(radians(marker.lat))).multiply(
                                cos(
                                    radians(marker.lon)
                                        .subtract(radians(Expressions.asNumber(lng)))
                                )
                            ).add(
                                sin(radians(Expressions.asNumber(lat)))
                                    .multiply(sin(radians(marker.lat)))
                            )
                    )
                )).loe(distance)
            )
            .fetch()


    }
}