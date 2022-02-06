package com.foameraserblue.carecat.web.entitiy

import javax.persistence.*

@Entity
@Table(name = "marker")
class Marker(
    @Id @Column(name = "marker_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "marker_lat")
    var lat: Double,

    @Column(name = "marker_lon")
    var lon: Double,

    @Embedded
    var markerDetails: MarkerDetails?

) {
}