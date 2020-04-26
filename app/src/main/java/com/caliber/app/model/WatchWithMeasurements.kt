package com.caliber.app.model

import androidx.room.Embedded
import androidx.room.Relation

data class WatchWithMeasurements(
    @Embedded val watch: Watch,
    @Relation(
        parentColumn = "id",
        entityColumn = "watchId"
    )
    val measurements: List<Measurement>
)
