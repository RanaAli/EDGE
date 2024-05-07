package com.rana.edge.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rana.edge.databinding.ListItemBinding
import com.rana.model.UniversityEntity

class MyAdapter(
    private val universities: List<UniversityEntity>,
    private val onClick: (UniversityEntity) -> Unit
) :
    RecyclerView.Adapter<MyAdapter.UniversityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UniversityViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        holder.bind(universities[position], onClick)
    }

    override fun getItemCount(): Int = universities.size

    class UniversityViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(entity: UniversityEntity, onClick: (UniversityEntity) -> Unit) {
            with(binding) {
                university = entity
                rootLayout.setOnClickListener { onClick.invoke(entity) }
            }
        }
    }
}