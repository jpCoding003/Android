package com.tops.android.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tops.android.pagers.PagerFragment

class MyViewPagerAdapter(val activity: FragmentActivity, val fragmentList: ArrayList<PagerFragment>) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        return fragmentList[position].fragment
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }
}