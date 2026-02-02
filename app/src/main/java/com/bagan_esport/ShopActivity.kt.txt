package com.bagan_esport

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ShopActivity : AppCompatActivity() {

    val heroes = mutableListOf(Hero("Hero A", 100), Hero("Hero B", 150))
    val players = mutableListOf(Player("Player A", 200), Player("Player B", 250))

    var type = "hero"
    var team: Team? = null
    lateinit var listView: ListView
    lateinit var buyBtn: Button
    var selectedIndex = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        type = intent.getStringExtra("type") ?: "hero"
        team = intent.getSerializableExtra("team") as? Team

        listView = findViewById(R.id.product_list)
        buyBtn = findViewById(R.id.buy_btn)

        val adapter = if (type == "hero") {
            ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, heroes.map { "${it.name} - ${it.price}" })
        } else {
            ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, players.map { "${it.name} - ${it.price}" })
        }

        listView.adapter = adapter
        listView.choiceMode = ListView.CHOICE_MODE_SINGLE

        listView.setOnItemClickListener { _, _, position, _ ->
            selectedIndex = position
        }

        buyBtn.setOnClickListener {
            if (selectedIndex == -1) return@setOnClickListener
            if (team == null) return@setOnClickListener

            if (type == "hero") {
                val hero = heroes[selectedIndex]
                if (team!!.heroes.size >= 2) {
                    Toast.makeText(this, "Hero maksimal 2", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (team!!.money < hero.price) {
                    Toast.makeText(this, "Uang tidak cukup", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                team!!.heroes.add(hero)
                team!!.money -= hero.price
            } else {
                val player = players[selectedIndex]
                if (team!!.players.size >= 2) {
                    Toast.makeText(this, "Player maksimal 2", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if (team!!.money < player.price) {
                    Toast.makeText(this, "Uang tidak cukup", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                team!!.players.add(player)
                team!!.money -= player.price
            }

            Toast.makeText(this, "Berhasil dibeli!", Toast.LENGTH_SHORT).show()
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}
