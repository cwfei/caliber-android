package com.caliber.app.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.sql.Timestamp
import java.util.*

@Entity
open class Measurement(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val createdDate: Date,
    val deviation: Double
)
