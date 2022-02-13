package com.foameraserblue.carecat.web.entity.Marker

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class MarkerDetails(
    @Column(name = "marker_address", length = 50)
    var street: String, //주소(구글맵 api 파라미터 변수명을 그대로 사용)

    @Column(name = "marker_detailLocation", length = 100)
    var detailLocation: String? = null, //유저가 직접 작성한 상세주소 설명

    @Column(name = "marker_comment", length = 100)
    var comment: String? = null // 유저가 작성한 장소에 관한 코멘트

) {
}