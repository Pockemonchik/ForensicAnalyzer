package com.example.forensicanalyzer.ui.cloud

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.forensicanalyzer.ui.cloud.services.ServicesFragment
import com.example.forensicanalyzer.ui.cloud.settings.SettingsFragment
import com.example.forensicanalyzer.ui.cloud.tasks.TasksFragment

class ViewPagerAdapter (fm: FragmentManager): FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
       return when (position) {
           0 -> ServicesFragment()
           1 -> TasksFragment()
           else -> return SettingsFragment()
       }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return  when (position) {
            0 -> "Сервисы"
            1 -> "Задания"
            else -> return "Настройки"
        }
    }

}