package com.jpabook.entity

import com.jpabook.kernel.UserStateConverter
import java.time.Instant
import javax.persistence.Column
import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "members")
class Member : BaseEntity() {
    @Id
    @GeneratedValue
    @Column
    val id: Long = 0

    @Column
    @Convert(converter = UserStateConverter::class)
    var state: UserState = UserState.BASIC
        protected set

    @Column
    var resignedAt: Instant? = null
        protected set

    fun resign() = apply {
        resignedAt = Instant.now()
        state = UserState.RESIGNED
    }
}