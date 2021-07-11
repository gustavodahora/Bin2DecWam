package com.example.bin2decwarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.substring
import android.view.View
import android.widget.Toast
import com.example.bin2decwarm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun backspace(v: View) {
        var length = binding.binary.text.length
        var text = binding.binary.text.toString()
        if (length > 0) {
            binding.binary.setText(text.substring(0, length - 1))
            binding.binary.setSelection(binding.binary.length())
        }
    }

    fun convert(v: View) {
        var length = binding.binary.text.length
        if (length > 0 && !binding.binary.text.isEmpty() && !binding.binary.text.isBlank()) {
            var binary = binding.binary.text.toString()
            var decimal = Integer.parseInt(binary, 2)
            binding.decimal.setText("$decimal") // Convert to binary
        } else {
            Toast.makeText(applicationContext, "Type an input", Toast.LENGTH_SHORT).show()
        }
    }

    fun one(v: View) {
        var binary = binding.binary.text.toString()

        if (binary == "0") {
            var binaryAddition = "1"
            binding.binary.setText(binaryAddition)
            binding.binary.setSelection(binding.binary.text.toString().length)
        } else {
            var binaryAddition = binary+"1"
            binding.binary.setText(binaryAddition)
            binding.binary.setSelection(binding.binary.text.toString().length)
        }

    }

    fun zero(v: View) {
        var binary = binding.binary.text.toString()

        if (binary != "0") {
            var binaryAddition = binary+"0"
            binding.binary.setText(binaryAddition)
            binding.binary.setSelection(binding.binary.text.toString().length)
        }
    }
}