package com.example.studentportal

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.example.studentportal.AddActivity.Companion.EXTRA_PORTAL

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

const val ADD_PORTAL_REQUEST_CODE = 100

class MainActivity : AppCompatActivity() {

    private val portals = arrayListOf<Portal>()
    private val portalAdapter = PortalAdapter(portals)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initViews()
        fab.setOnClickListener { startAddActivity() }
        btnVlo.setOnClickListener { openBrowser("vlo") }
        btnSchedule.setOnClickListener { openBrowser("schedule") }
        btnSis.setOnClickListener { openBrowser("sis") }
        btnHva.setOnClickListener{ openBrowser("hva") }
    }

    private fun initViews() {
        // Initialize the recycler view with a linear layout manager, adapter
        rvPortals.layoutManager = GridLayoutManager(this@MainActivity, 2)
        rvPortals.adapter = portalAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun startAddActivity() {
        val intent = Intent(this, AddActivity::class.java)
        startActivityForResult(intent, ADD_PORTAL_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                ADD_PORTAL_REQUEST_CODE -> {
                    val portal = data!!.getParcelableExtra<Portal>(EXTRA_PORTAL)
                    portals.add(portal)
                    portalAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    private fun openBrowser(category: String) {
        when (category) {
            "vlo" -> startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://hva.nl")))
            "schedule" -> startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://rooster.hva.nl")))
            "sis" -> startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://sis.hva.nl")))
            "hva" -> startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://vlo.informatica.hva.nl")))
        }
    }

}
