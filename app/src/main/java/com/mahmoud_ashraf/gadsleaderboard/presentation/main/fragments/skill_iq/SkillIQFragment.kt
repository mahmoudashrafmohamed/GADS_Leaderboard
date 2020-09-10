package com.mahmoud_ashraf.gadsleaderboard.presentation.main.fragments.skill_iq

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.mahmoud_ashraf.gadsleaderboard.R
import com.mahmoud_ashraf.gadsleaderboard.databinding.FragmentLearningBinding
import com.mahmoud_ashraf.gadsleaderboard.databinding.FragmentSkillIQBinding
import com.mahmoud_ashraf.gadsleaderboard.presentation.main.MainViewModel
import com.mahmoud_ashraf.gadsleaderboard.presentation.main.fragments.learning_leaders.adapters.LearningLeadersRecyclerAdapter
import com.mahmoud_ashraf.gadsleaderboard.presentation.main.fragments.skill_iq.adapters.SkillLeadersRecyclerAdapter
import com.mahmoud_ashraf.gadsleaderboard.presentation.utils.Resource

class SkillIQFragment : Fragment() {
    private var _binding: FragmentSkillIQBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()
    private val adapter by lazy { SkillLeadersRecyclerAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSkillIQBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = adapter
        viewModel.skilledLeadersLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Loading -> {
                    Toast.makeText(requireContext(), "Please wait ...", Toast.LENGTH_SHORT).show()
                }
                is Resource.Success -> it.data?.let { list ->
                    adapter.submitList(list)
                }
                is Resource.Error -> {
                    Toast.makeText(
                        requireContext(),
                        "Something wrong is happened!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SkillIQFragment()

    }
}