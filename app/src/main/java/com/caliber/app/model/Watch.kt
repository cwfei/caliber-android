package com.caliber.app.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
open class Watch(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val model: String?,
    val brand: String?,
    val serial: String?,
    val notes: String?
)
