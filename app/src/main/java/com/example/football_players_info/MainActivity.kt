package com.example.football_players_info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.RecoverySystem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var  mainRecyclerViewAdapter: MainRecyclerViewAdapter
    private lateinit var players: ArrayList<Player>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       players = ArrayList()
        addItems()

        initViews()
    }

    private fun initViews() {
        val mainRv = findViewById<RecyclerView>(R.id.rv_main)

        mainRecyclerViewAdapter = MainRecyclerViewAdapter(players)

        mainRv.apply {
            adapter = mainRecyclerViewAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun addItems() {
        for(i in 1..10){
            players.add(Player("Sarvar",R.drawable.ic_launcher_background,"Puli yo`q",false,"https://championat.asia/"))
        }
    }
}