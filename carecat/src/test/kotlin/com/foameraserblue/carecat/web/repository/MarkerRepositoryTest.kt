package com.foameraserblue.carecat.web.repository

import com.foameraserblue.carecat.config.QuerydslConfig
import com.foameraserblue.carecat.web.repository.marker.MarkerRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 내장DB가 아닌 YML에 설정한 DB사용
@Import(QuerydslConfig::class)  // 쿼리DSL CONFIG파일 IMPORT
class MarkerRepositoryTest : BehaviorSpec() {
    override fun extensions() = listOf(SpringExtension) // kotest-extensions-spring사용을 위해 설정

    @Autowired
    private lateinit var markerRepository: MarkerRepository

    init {
        this.given("위도,경도,길이 조건 주어짐") {
            val lat = 37.4608071
            val lng = 126.6443407
            val distance = 6.78

            `when`("adjMarker 함수를 호출하면") {
                val adjMarkerResponses = markerRepository.adjMarker(lat, lng, distance)

                then("AdjMarkerResponseDto 리스트가 반환된다") {
                    adjMarkerResponses shouldHaveSize 0

                }
            }
        }
    }
}
