package com.example.hw4_intent

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.widget.Toast

private const val REQUEST_CODE_SHARE = 1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_some_semantic.setOnClickListener(){
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Hi")
                type = "text/plain"
            }
            startActivityForResult(sendIntent, REQUEST_CODE_SHARE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_SHARE && resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "Shared", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Is Failed message", Toast.LENGTH_SHORT).show()
        }
    }
}
