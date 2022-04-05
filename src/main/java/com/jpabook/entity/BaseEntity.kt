package com.jpabook.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import java.time.Instant
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
@EnableJpaAuditing
abstract class BaseEntity {
    @CreatedDate
    @Column
    var createdAt: Instant = Instant.MIN
        protected set

    @LastModifiedDate
    @Column
    var updatedAt: Instant = Instant.MIN
        protected set
}