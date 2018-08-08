package com.coffietocode.comicapps.comicmania.view.activity

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.coffietocode.comicapps.comicmania.R
import com.coffietocode.comicapps.comicmania.utils.ThemeChooser
import com.coffietocode.comicapps.comicmania.view.dialog.DialogHandler
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var mDialog: DialogHandler
    @Inject
    lateinit var mThemeChooser: ThemeChooser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        mDialog.initiate(this)

        setSupportActionBar(toolbar)

        setupNavigationDrawer()
    }

    private fun setupNavigationDrawer() {
        val drawerToggle = ActionBarDrawerToggle(
                this,
                drawer_layout,
                toolbar,
                R.string.action_drawer_open,
                R.string.action_drawer_close)

        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        navigation_view.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            val itemId = item.itemId
            when (itemId) {
                R.id.change_theme -> {
                    mThemeChooser.showThemChooserDialog(this)
                    return true
                }
            }
        }
        return false
    }
}
