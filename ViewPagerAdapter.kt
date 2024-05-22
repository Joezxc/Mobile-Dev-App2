package com.example.app2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OrderFragment()
            1 -> PreferencesFragment()
            else -> OrderFragment()
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}