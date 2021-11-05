package com.geek.kotlin1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geek.kotlin1.MainActivity.Companion.TEXT
import com.geek.kotlin1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        btnListener()

    }

    private fun btnListener() {
        viewBinding.etSecond.setText(intent.getStringExtra(TEXT))
        viewBinding.btnSend.setOnClickListener {
            if (viewBinding.etSecond.text.toString().isEmpty()) {
                Toast.makeText(
                    this, getString(R.string.toast_empty), Toast.LENGTH_SHORT).show()
            } else sendSecondData()
        }
    }

    private fun sendSecondData() {
        Intent(this, MainActivity::class.java).apply {
            putExtra(TEXT, viewBinding.etSecond.text.toString())
            setResult(Activity.RESULT_OK, this)
            finish()
        }
    }
}