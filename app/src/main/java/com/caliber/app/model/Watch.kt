package com.caliber.app.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
open class Watch(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val name: String
)
