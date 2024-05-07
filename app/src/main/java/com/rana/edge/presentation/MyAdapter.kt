package com.rana.edge.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rana.model.UniversityEntity
import com.rana.edge.databinding.ListItemBinding

class MyAdapter(
    private val universities: List<com.rana.model.UniversityEntity>,
    private val onClick: (com.rana.model.UniversityEntity) -> Unit
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

        fun bind(entity: com.rana.model.UniversityEntity, onClick: (com.rana.model.UniversityEntity) -> Unit) {
            with(binding) {
                university = entity
                rootLayout.setOnClickListener { onClick.invoke(entity) }
            }
        }
    }
}