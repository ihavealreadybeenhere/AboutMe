package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener { addNickname(it) }
    }
    
    private fun addNickname(view: View) {
        // view is a  View on which was performed an action,
        // so its a button "done"
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nickNameTextView = findViewById<TextView>(R.id.nickname_text)
        nickNameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nickNameTextView.visibility = View.VISIBLE

        // Hide the Keyboard
        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken, 0)
    }
}