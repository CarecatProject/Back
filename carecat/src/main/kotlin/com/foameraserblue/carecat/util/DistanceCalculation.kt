package com.foameraserblue.carecat.util

import kotlin.math.pow

/**
 * https://gis.stackexchange.com/questions/7430/what-ratio-scales-do-google-maps-zoom-levels-correspond-to
 *
 * 위 사이트를 참조로하여 google map의 zoom size에 관련한 사용자 화면 범위를 계산하는 클래스
 * companion 메서드로 계산만을 위해 사용되며, 객체를 따로 생성할 필요 없음.
 */
class DistanceCalculation private constructor() {

    companion object {

        @JvmStatic
        fun getAdjDistance(zoom: Int): Double {
            return 591657550.500000 / (2.0).pow(zoom.toDouble())
        }

        @JvmStatic
        fun getAdjDistance(zoom: Double): Double {
            return 591657550.500000 / (2.0).pow(zoom)
        }
    }

}