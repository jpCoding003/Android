package com.tops.android

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tops.android.adapter.MyViewPagerAdapter
import com.tops.android.databinding.ActivityViewPagerBinding
import com.tops.android.pagers.PagerFragment
import com.tops.android.ui.gallery.GalleryFragment
import com.tops.android.ui.home.HomeFragment
import com.tops.android.ui.slideshow.SlideshowFragment

class ViewPagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fragmentList : ArrayList<PagerFragment> = arrayListOf(
            PagerFragment(GalleryFragment()," Gallery"),
            PagerFragment(HomeFragment()," Home"),
            PagerFragment(SlideshowFragment()," Slideshow")
        )
        val adapter = MyViewPagerAdapter(this, fragmentList);
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout,binding.viewPager, object: TabLayoutMediator.TabConfigurationStrategy{
            override fun onConfigureTab(
                tab: TabLayout.Tab,
                position: Int
            ) {
                tab.text = fragmentList[position].title
                tab.icon = getDrawable(R.mipmap.ic_launcher)
            }
        }).attach()
    }
}