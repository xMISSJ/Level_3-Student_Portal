package com.example.studentportal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        initViews()
        btnAddPortal.setOnClickListener{ onAddClick()}
        etUrl.setText("http://")
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Create a portal"
    }

    private fun onAddClick(){
        // Check whether the input isn't empty.
        if (etTitle.text.toString().isNotBlank() && etUrl.text.toString().isNotBlank()) {
            val portal = Portal(etTitle.text.toString(), etUrl.text.toString())
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_PORTAL, portal)
            // This resultIntent is then passed back to the calling activity.
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this,"The portal cannot be empty!"
                , Toast.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    companion object {
        const val EXTRA_PORTAL = "EXTRA_PORTAL"
    }
}

