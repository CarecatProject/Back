package com.foameraserblue.carecat.web.entitiy

import javax.persistence.*

@Entity
class User(
    @Id @Column(name = "user_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "user_name")
    var name: String,

    @Column(name = "user_email", unique = true)
    var email: String,


    ) {


}