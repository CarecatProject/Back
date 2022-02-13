package com.foameraserblue.carecat.web.entity.Marker

import javax.persistence.*

@Entity
class Marker(

    @Id
    @Column(name = "marker_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "marker_lat")
    var lat: Double, //위도

    @Column(name = "marker_lng")
    var lng: Double, //경도

    @Embedded
    var markerDetails: MarkerDetails //상세정보

) {


}