package com.bignerdranch.android.criminalintent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.criminalintent.databinding.ListItemCrimeBinding
import com.bignerdranch.android.criminalintent.databinding.ListItemSeriousCrimeBinding

class GeneralCrimeHolder(
    private val binding: ListItemCrimeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.crimeSolved.visibility = if (crime.isSolved) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}

class SeriousCrimeHolder(
    private val binding: ListItemSeriousCrimeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(crime: Crime) {
        binding.seriousCrimeTitle.text = crime.title
        binding.seriousCrimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.contactPoliceButton.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "contact police about ${crime.title}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.crimeSolved.visibility = if (crime.isSolved) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}

class CrimeListAdapter(
    private val crimes: List<Crime>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            Crime.TYPE_GENERAL_CRIME -> {
                val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
                GeneralCrimeHolder(binding)
            }
            Crime.TYPE_SERIOUS_CRIME -> {
                val binding = ListItemSeriousCrimeBinding.inflate(inflater, parent, false)
                SeriousCrimeHolder(binding)
            }
            else -> throw IllegalArgumentException("[ERROR] onCreateViewHolder(...) -- WRONG `viewType`")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val crime = crimes[position]

        when (holder) {
            is GeneralCrimeHolder -> holder.bind(crime)
            is SeriousCrimeHolder -> holder.bind(crime)
            else -> throw IllegalArgumentException("[ERROR] onBindViewHolder(...) -- WRONG `holder`")
        }
    }

    override fun getItemCount(): Int = crimes.size

    override fun getItemViewType(position: Int): Int {
        return if (crimes[position].requiresPolice)
            Crime.TYPE_SERIOUS_CRIME
        else
            Crime.TYPE_GENERAL_CRIME
    }
}