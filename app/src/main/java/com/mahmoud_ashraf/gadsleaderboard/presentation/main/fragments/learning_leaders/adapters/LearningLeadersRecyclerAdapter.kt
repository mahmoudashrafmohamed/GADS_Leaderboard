package com.mahmoud_ashraf.gadsleaderboard.presentation.main.fragments.learning_leaders.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahmoud_ashraf.gadsleaderboard.data.models.Leader
import com.mahmoud_ashraf.gadsleaderboard.databinding.ItemLearningLeadersBinding

class LearningLeadersRecyclerAdapter(): RecyclerView.Adapter<
        LearningLeadersRecyclerAdapter.ViewHolder>() {

    private var list: List<Leader> = emptyList()

    fun submitList(list: List<Leader>){
        this.list = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemLearningLeadersBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item : Leader){
            binding.nameTv.text = item.name
            binding.infoTv.text = item.hours.toString() + " learning hours, " + item.country
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLearningLeadersBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }
}