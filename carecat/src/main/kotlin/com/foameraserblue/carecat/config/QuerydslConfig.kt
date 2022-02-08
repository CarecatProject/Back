package com.foameraserblue.carecat.config

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

/**
 * 쿼리 dsl 설정정보 저장
 */
@Configuration
class QuerydslConfig(@PersistenceContext val entityManager: EntityManager) {
    @Bean
    fun jpaQueryFactory() = JPAQueryFactory(entityManager)

}