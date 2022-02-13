package com.foameraserblue.carecat.web.repository.marker

import com.foameraserblue.carecat.web.entity.Marker.Marker
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MarkerRepository : JpaRepository<Marker, Long>, MarkerRepositoryCustom {
}