package com.bignerdranch.android.criminalintent

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID

private const val TAG = "CrimeListViewModel"

class CrimeListViewModel: ViewModel() {

    val crimes = mutableListOf<Crime>()

    init {
        Log.d(TAG, "init starting")

        viewModelScope.launch {
            Log.d(TAG, "coroutine launched")

            crimes += loadCrimes()

            Log.d(TAG, "Loading crimes finished")
        }
    }

    suspend fun loadCrimes(): List<Crime> {
        val result = mutableListOf<Crime>()

        delay(5000) // suspending function

        val dateFormatter = SimpleDateFormat("EEEE, MMMM dd, yyyy.", Locale.ENGLISH)

        for (i in 0 until 100) {
            val crime = Crime(
                id = UUID.randomUUID(),
                title = "Crime #$i",
                date = dateFormatter.format(Date()),
                isSolved = i % 2 == 0,
                requiresPolice = i % 3 == 0
            )

            result += crime
        }

        return result
    }
}