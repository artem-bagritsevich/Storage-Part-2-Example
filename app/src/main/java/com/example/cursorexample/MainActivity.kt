package com.example.cursorexample

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.cursorexample.adapter.CursorAdapterExample
import com.example.cursorexample.db.RSSchoolSQLiteOpenHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = RSSchoolSQLiteOpenHelper(this)

        @Suppress("UNUSED_VARIABLE")
        val arrayAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            database.getListOfTopics()
        )
        val cursorAdapter = CursorAdapterExample(this@MainActivity, database.getCursorWithTopics())

        listView.apply {
            adapter = cursorAdapter
        }
    }
}