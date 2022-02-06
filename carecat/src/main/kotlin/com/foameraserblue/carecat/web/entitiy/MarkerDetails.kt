package com.foameraserblue.carecat.web.entitiy

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class MarkerDetails(
    @Column(name = "marker_address", length = 50)
    var address: String,

    @Column(name = "marker_detailLocation", length = 100)
    var detailLocation: String?,

    @Column(name = "marker_comment", length = 100)
    var comment: String?

) {
}