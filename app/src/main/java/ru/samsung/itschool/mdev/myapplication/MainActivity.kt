package ru.samsung.itschool.mdev.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var persons: List<Person>
    private lateinit var recyclerView: RecyclerView
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fileResult = application.assets.open("persons.json").bufferedReader().use { it.readText() }
        val gson = GsonBuilder().create()
        persons = gson.fromJson(fileResult,Array<Person>::class.java).toList()
        Log.d("RRR",persons.get(0).name)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MyAdapter(persons)
        recyclerView.adapter = adapter
        btn1 = findViewById(R.id.btnName)
        btn2 = findViewById(R.id.btnSex)
        btn3 = findViewById(R.id.btnPhone)
        sortBy()
    }

    fun sortBy() {
        btn1.setOnClickListener {
            recyclerView.adapter = MyAdapter(persons.sortedBy { it.name })
        }
        btn2.setOnClickListener {
            recyclerView.adapter = MyAdapter(persons.sortedBy { it.sex })
        }
        btn3.setOnClickListener {
            recyclerView.adapter = MyAdapter(persons.sortedBy { it.phoneNumber })
        }
    }
}
data class Person(val name: String, val sex: Char, val phoneNumber: String)