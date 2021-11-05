package com.geek.kotlin1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.geek.kotlin1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

//    //поздняя инициализация
//    lateinit var swimming: String
//    var hour: Double? = null  // нужно делать проверку
//
//
//    //целочисленные переменные
//    var age: Int = 3 // явное обявленение
//    var size = 14 // не явное объявление
//    var  short: Short = 3232
//    var long: Long = 33333L
//
//    // строковые переменные
//    var name: String = "App" // изменяемая переменная
//    val surname = "Surname" // не изменяемая
//    var char: Char = 'c'
//
//    // дробные переменные
//    var f: Float = 43.5f
//    var f1 = 43.5f
//    var d: Double = 3.5
//
//    // условные переменные
//    var isLoading: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForActivity()

        binding.btnSend.setOnClickListener {
            if (binding.etFirst.text.toString().isEmpty()) {
                showToast(getString(R.string.toast_empty))
            } else sendData()
        }
    }

    private fun registerForActivity() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                binding.etFirst.setText(result.data?.getStringExtra(TEXT))
            }
        }
    }

    private fun sendData(){
        Intent(this, MainActivity2::class.java).apply {
            putExtra(TEXT, binding.etFirst.text.toString())
            resultLauncher.launch(this)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val TEXT = "text"
    }

//        swimming = "next"
//
//        when(isLoading) {
//            true -> showToast("true")
//            false -> showToast("false")
//        }
//
//        when(size){
//            12 -> showToast(size.toString())
//        }
//
//        showToast(checkSize("XL"))
//        showToast(checkSize("XLL"))
//    }
//
//    private fun checkSize(size: String): String {
//        return when(size) {
//            "XL" -> "You are big"
//            else -> "You are $size"
//        }
//    }
//
//    private fun showToast(message: String) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//    }
}