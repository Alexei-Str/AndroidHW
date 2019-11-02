package com.example.hw5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class PageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        film_image_view.setImageResource(intent.getIntExtra("img", R.mipmap.ic_launcher))
        title_text_view.text = intent.getStringExtra("title").toString()
        description_text_view.text = intent.getStringExtra("description").toString()
    }
}