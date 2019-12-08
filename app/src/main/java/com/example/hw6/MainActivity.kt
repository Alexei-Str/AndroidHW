package com.example.hw6

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.hw6.ui.home.HomeFragment
import com.example.hw6.ui.messages.MessagesFragment
import com.example.hw6.ui.news.NewsFragment
import com.example.hw6.ui.review.ReviewFragment
import com.example.hw6.ui.review.ReviewFragment2
import com.example.hw6.ui.review.ReviewFragment3
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), ReviewFragment.onButtonClick, ReviewFragment2.onButtonClick {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onSendReportBtnClick(info: String, review: String, bugs: String) {
        supportFragmentManager.also {
            it.beginTransaction().apply {
                setCustomAnimations(R.animator.enter_from_left, R.animator.enter_from_top)
                replace(R.id.nav_host_fragment, ReviewFragment3().apply {
                    arguments = Bundle().apply {
                        putString("info", info)
                        putString("review", review)
                        putString("bugs", bugs)
                    }
                }, "lastFragment")
                addToBackStack(null).commit()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        nav_view.setNavigationItemSelectedListener(this::onNavigationItemSelected)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.nav_host_fragment, HomeFragment())
            .addToBackStack(null)
            .commit()
        val toggle = ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
            // Доп.задание: проверка текущего фрагмента, если текущий фрагмент является фрагментом Review3,
            // то при нажатии кнопки back проиходит возврат на 4 фрагмент, минуя 5 (6->4)
        if (supportFragmentManager.findFragmentByTag("lastFragment") == null) {
            when {
                drawer.isDrawerOpen(GravityCompat.START) -> drawer.closeDrawer(GravityCompat.START)
                supportFragmentManager.backStackEntryCount > 0 -> supportFragmentManager.popBackStack()
                else -> super.onBackPressed()
            }
        }else{
            supportFragmentManager.popBackStack()
            supportFragmentManager.popBackStack()
        }
    }

    override fun onReportBtnClick() {
        supportFragmentManager.also {
            it.beginTransaction().apply {
                setCustomAnimations(R.animator.enter_from_left, R.animator.enter_from_top)
                replace(R.id.nav_host_fragment, ReviewFragment2())
                addToBackStack(null).commit()
            }
        }
    }

    private fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fragment = when (item.itemId) {
            R.id.nav_home -> HomeFragment()
            R.id.nav_news -> NewsFragment()
            R.id.nav_messages -> MessagesFragment()
            R.id.nav_review -> ReviewFragment()
            else -> error("Item doesn't exist")
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .addToBackStack(null)
            .commit()
        title = item.title
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
