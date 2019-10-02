package com.example.studentportal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        initViews()
        btnAddPortal.setOnClickListener{}
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Create a portal"

        btnAddPortal.setOnClickListener{ onAddClick()}
    }

    private fun onAddClick(){
        // Check whether the input isn't empty.
        if (etTitle.text.toString().isNotBlank() && etUrl.text.toString().isNotBlank()) {
            val portal = Portal(etAddReminder.text.toString())
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_REMINDER, reminder)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else {
            Toast.makeText(this,"The reminder cannot be empty!"
                , Toast.LENGTH_SHORT).show()
        }
    }
}
