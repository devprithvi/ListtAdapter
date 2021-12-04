package com.devprithvi.listtadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/*
in this project i used Diffutil and listAdapter
DIFFUTIL >>>>>>
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.progList)
        val adapter = ProgrammingAdapter()


        val p1 = ProgrammingItem(1, "j", "Java")
        val p2 = ProgrammingItem(2, "k", "Kotlin")
        val p3 = ProgrammingItem(3, "l", "Android")

        //to set the initial data to the list through adpater
        adapter.submitList(listOf(p1, p2, p3))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        //after 4 second we get new list...and update the list
        Handler (Looper.getMainLooper()).postDelayed(Runnable {
            val p3 = ProgrammingItem(3, "l", "Android")
            val p4 = ProgrammingItem(4, "R", "NET")
            val p5 = ProgrammingItem(5, "K", "POP")
            val p6 = ProgrammingItem(6, "P", "ICE")

            adapter.submitList(listOf(p3,p4,p5,p6))
        },4000)
    }
}