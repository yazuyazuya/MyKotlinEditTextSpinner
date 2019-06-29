package com.example.yazuyazuya.mykotlinedittextspinner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Spinnerの選択肢
    private val spinnerItems = arrayOf(
            "何か選んでごらん",
            "モンスト",
            "デレステ",
            "スクフェス",
            "プリコネ",
            "崩壊3rd",
            "刀使ノ巫女",
            "ドルフロ",
            "艦これ",
            "アズレン"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // EditTextのプログラム
        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById(R.id.button) as Button

        button.setOnClickListener {
            if (editText.text != null) {
                textView.text = editText.text.toString()
            }
        }

        // Spinnerのプログラム
        val textView2 = findViewById<TextView>(R.id.textView2)

        val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item,
                spinnerItems)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val spinnerParent = parent as Spinner
                val item = spinnerParent.selectedItem as String

                textView2.text = item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

    }
}
