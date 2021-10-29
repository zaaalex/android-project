package com.example.lab4

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.lab4.databinding.ActivityMainBinding
import com.example.lab4.ui.events.EventsFragment
import com.example.lab4.ui.holiday.HolidayFragment
import com.example.lab4.ui.log.Logcycle
import com.example.lab4.ui.profile.ProfileFragment
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logcycle(lifecycle, "MainActivity")

        setContentView(R.layout.activity_main)
        openFragment(EventsFragment())
        seturBottomNavigationBar();
    }

    private fun seturBottomNavigationBar(){
        val bottomNavigation: BottomNavigationView=findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation!!.setOnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.navigation_events -> { openFragment(EventsFragment())
                    true}
                R.id.navigation_holiday -> {openFragment(HolidayFragment())
                    true}
                R.id.navigation_profile -> {openFragment(ProfileFragment())
                    true}
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}
