package com.mahmoud_ashraf.gadsleaderboard.presentation.main.fragments.skill_iq.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahmoud_ashraf.gadsleaderboard.data.models.Leader
import com.mahmoud_ashraf.gadsleaderboard.databinding.ItemLearningLeadersBinding
import com.mahmoud_ashraf.gadsleaderboard.databinding.ItemSkillIqBinding

class SkillLeadersRecyclerAdapter(): RecyclerView.Adapter<
        SkillLeadersRecyclerAdapter.ViewHolder>() {

    private var list: List<Leader> = emptyList()

    fun submitList(list: List<Leader>){
        this.list = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemSkillIqBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item : Leader){
            binding.nameTv.text = item.name
            binding.infoTv.text = item.score.toString() + " Skill IQ Score, " + item.country
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSkillIqBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }
}