package com.example.cursorexample.adapter

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cursoradapter.widget.CursorAdapter
import com.example.cursorexample.db.TOPIC_COLUMN

class CursorAdapterExample(context: Context, cursor: Cursor) :
    CursorAdapter(context, cursor, true) {

    override fun newView(context: Context, cursor: Cursor?, parent: ViewGroup?): View {
        return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, null)
    }

    override fun bindView(view: View, context: Context?, cursor: Cursor) {
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.text = cursor.getString(cursor.getColumnIndex(TOPIC_COLUMN))
    }
}
