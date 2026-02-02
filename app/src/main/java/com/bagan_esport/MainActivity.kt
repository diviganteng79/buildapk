package com.bagan_esport

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addBtn = findViewById<Button>(R.id.add_team_btn)
        val listView = findViewById<ListView>(R.id.team_list)

        val teams = mutableListOf<Team>()
        val adapter = TeamAdapter(this, teams)
        listView.adapter = adapter

        addBtn.setOnClickListener {
            startActivity(Intent(this, ShopActivity::class.java))
        }
    }
}
