package com.rana.edge.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rana.edge.data.local.UniversityEntity
import com.rana.edge.databinding.ListItemBinding

class MyAdapter(private val universities: List<UniversityEntity>) :
    RecyclerView.Adapter<MyAdapter.UniversityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UniversityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        val university = universities[position]
        holder.bind(university)
    }

    override fun getItemCount(): Int = universities.size

    class UniversityViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(university: UniversityEntity) {
            binding.university = university
//            nameTextView.text = university.name
//            countryTextView.text = university.country
        }
    }
}