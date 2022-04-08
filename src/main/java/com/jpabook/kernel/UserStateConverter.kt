package com.jpabook.kernel

import com.jpabook.domain.UserState
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class UserStateConverter : AttributeConverter<UserState, Int> {
    override fun convertToDatabaseColumn(attribute: UserState?) = attribute?.value

    override fun convertToEntityAttribute(dbData: Int?) = UserState.values().find { it.value == dbData }
}