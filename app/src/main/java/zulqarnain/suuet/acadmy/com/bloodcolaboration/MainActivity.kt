package zulqarnain.suuet.acadmy.com.bloodcolaboration

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import zulqarnain.suuet.acadmy.com.bloodcolaboration.ui.FeedFragement
import zulqarnain.suuet.acadmy.com.bloodcolaboration.ui.RequestFragement

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        nav_view.setNavigationItemSelectedListener(this)

        if (fragment == null) {
            fragment = FeedFragement.newInstance();
            supportFragmentManager.beginTransaction().add(R.id.admin_fragment_container, fragment).commit()

        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.nav_home -> {
                fragment = FeedFragement.newInstance()

            }
            R.id.nav_request -> {
                fragment = RequestFragement.newInstance()

            }

        }
        if (fragment != null)
            supportFragmentManager.beginTransaction().replace(R.id.admin_fragment_container, fragment).commit()


        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
