package com.mahmoud_ashraf.gadsleaderboard.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mahmoud_ashraf.gadsleaderboard.R
import com.mahmoud_ashraf.gadsleaderboard.databinding.ActivityMainBinding
import com.mahmoud_ashraf.gadsleaderboard.presentation.main.adapters.LeaderBoardFragmentAdapter
import com.mahmoud_ashraf.gadsleaderboard.presentation.submit.SubmitActivity

class MainActivity : AppCompatActivity() {
  private var tabLayout: TabLayout? = null
  private var viewPager2: ViewPager2? = null
  private lateinit var binding: ActivityMainBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)
    tabLayout = binding.tabs
    viewPager2 = binding.vpLeaderBoard
    viewPager2!!.adapter = LeaderBoardFragmentAdapter(supportFragmentManager, lifecycle)
    TabLayoutMediator(tabLayout!!, viewPager2!!) { tab, position ->
      when (position) {
        0 -> tab.text = getString(R.string.learning_leaders)
        1 -> tab.text = getString(R.string.skill_iq_leaders)
      }
    }.attach()

    binding.toolbarSubmitButton.setOnClickListener {
      startActivity(Intent(this,SubmitActivity::class.java))
    }
  }
}