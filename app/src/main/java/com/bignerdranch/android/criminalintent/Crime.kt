package com.bignerdranch.android.criminalintent

import java.util.Date
import java.util.UUID

data class Crime(
    val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean,
    var requiresPolice: Boolean,
) {
    companion object {
        const val TYPE_GENERAL_CRIME = 0
        const val TYPE_SERIOUS_CRIME = 1
    }
}
