package com.mahmoud_ashraf.gadsleaderboard.presentation.main.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mahmoud_ashraf.gadsleaderboard.presentation.main.fragments.learning_leaders.LearningFragment
import com.mahmoud_ashraf.gadsleaderboard.presentation.main.fragments.skill_iq.SkillIQFragment


class LeaderBoardFragmentAdapter(manager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(manager, lifecycle) {

    override fun getItemCount(): Int {
        return screensNumber
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = LearningFragment.newInstance()
            1 -> fragment = SkillIQFragment.newInstance()
        }
        return fragment!!
    }

    companion object {
        private const val screensNumber = 2
    }


}
