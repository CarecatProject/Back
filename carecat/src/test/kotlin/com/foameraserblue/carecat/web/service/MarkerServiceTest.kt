package com.foameraserblue.carecat.web.service

import com.foameraserblue.carecat.web.repository.marker.MarkerRepository
import io.kotest.core.spec.style.BehaviorSpec
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MarkerServiceTest : BehaviorSpec() {
    @Autowired
    private lateinit var markerRepository: MarkerRepository
    init {
        given("AdjMarkerRequestDto") {
            `when`("위도, 경도, 줌사이즈, 사용자 핸드폰의 길이를 받으면") {
                then("df") {

                }

            }
        }
    }

}