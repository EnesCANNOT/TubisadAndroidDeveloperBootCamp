package com.helloworldstudios.paparaclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.helloworldstudios.paparaclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private lateinit var mFragmentList: ArrayList<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.viewPager
        tabLayout = binding.tabLayout

        mFragmentList = ArrayList<Fragment>()
        mFragmentList.add(Fragment1())
        mFragmentList.add(Fragment2())

        tabLayout.addTab(tabLayout.newTab().setText("CEP NUMARASI"))
        tabLayout.addTab(tabLayout.newTab().setText("PAPARA NO/IBAN"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val viewPagerAdapter = ViewPagerAdapter(this, mFragmentList, supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
        //tabLayout.setupWithViewPager(viewPager)

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }
}
