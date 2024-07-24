package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

class CrimeListViewModel: ViewModel() {

    val crimes = mutableListOf<Crime>()

    init {
        val dateFormatter = SimpleDateFormat("EEEE, MMMM dd, yyyy.", Locale.ENGLISH)

        for (i in 0 until 100) {
            val crime = Crime(
                id = UUID.randomUUID(),
                title = "Crime #$i",
                date = dateFormatter.format(Date()),
                isSolved = i % 2 == 0,
                requiresPolice = i % 3 == 0
            )

            crimes += crime
        }
    }
}