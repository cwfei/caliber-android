package com.caliber.app.model.params

import com.caliber.app.model.Watch

class WatchBuilder {

    var brand: String? = null
        private set

    var model: String? = null
        private set

    var serial: String? = null
        private set

    var notes: String? = null
        private set

    fun setBrand(brand: String?): WatchBuilder {
        this.brand = brand
        return this
    }

    fun setModel(model: String?): WatchBuilder {
        this.model = model
        return this
    }

    fun setSerial(serial: String?): WatchBuilder {
        this.serial = serial
        return this
    }

    fun setNotes(notes: String?): WatchBuilder {
        this.notes = notes
        return this
    }

    fun build(): Watch {
        return Watch(
            model = this.model,
            brand = this.brand,
            serial = this.serial,
            notes = this.notes
        )
    }
}
