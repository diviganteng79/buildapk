package com.bagan_esport

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class TeamAdapter(private val context: Context, private val teams: List<Team>) : BaseAdapter() {
    override fun getCount(): Int = teams.size
    override fun getItem(position: Int): Any = teams[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false)
        val team = teams[position]

        val text1 = view.findViewById<TextView>(android.R.id.text1)
        val text2 = view.findViewById<TextView>(android.R.id.text2)

        text1.text = team.name
        text2.text = "Uang: ${team.money}, Piala: ${team.trophies}, Juara: ${team.championships}"

        return view
    }
}
