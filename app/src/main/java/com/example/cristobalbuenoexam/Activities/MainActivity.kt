package com.example.cristobalbuenoexam.Activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cristobalbuenoexam.AbstractClass.BaseActivity
import com.example.cristobalbuenoexam.Fragments.CharactersFragment
import com.example.cristobalbuenoexam.Fragments.FavoritesFragment
import com.example.cristobalbuenoexam.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    val TAG = "miapp"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout()
    }

    fun tabLayout() {

        val myAdapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> {
                        CharactersFragment()
                    }
                    1 -> {
                        FavoritesFragment()
                    }
                    else -> {
                        CharactersFragment()
                    }
                }
            }
            override fun getItemCount(): Int {
                return 2
            }
        }
        mainContainer.adapter = myAdapter

        TabLayoutMediator(mainTabLayout, mainContainer) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Characters"
                }
                1 -> {
                    tab.text = "Favorites"
                }
            }
        }.attach()
    }
}
