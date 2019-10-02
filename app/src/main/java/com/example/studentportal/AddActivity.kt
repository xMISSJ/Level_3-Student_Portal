package com.example.studentportal

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*

const val EXTRA_PORTAL = "EXTRA_PORTAL"

class AddActivity : AppCompatActivity() {

    private var portalUri: Uri? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        initViews()
        btnAddPortal.setOnClickListener{}
        btnAddPortal.setOnClickListener{ onAddClick()}
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Create a portal"
    }

    private fun onAddClick(){
        // Check whether the input isn't empty.
        if (etTitle.text.toString().isNotBlank() && etUrl.text.toString().isNotBlank()) {
            portalUri = Uri.parse(etUrl.toString())
            val portal = Portal(etTitle.text.toString(), portalUri)
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_PORTAL, portal)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this,"The portal cannot be empty!"
                , Toast.LENGTH_SHORT).show()
        }
    }
}

