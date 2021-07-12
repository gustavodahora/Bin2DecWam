package com.example.bin2decwarm

import android.R.attr.label
import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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

    fun copy(v: View) {
        val decimal = binding.decimal.text
        val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("decimal", decimal)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(applicationContext, "Number $decimal has been copied to clipboard", Toast.LENGTH_SHORT).show()
    }

    fun paste(v: View) {
        val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val paste = clipboard?.primaryClip
        val item = paste?.getItemAt(0)

        binding.binary.setText(item?.text.toString())
        binding.binary.setSelection(binding.binary.text.toString().length)

    }

    fun clean(v: View) {
        binding.binary.setText("")
        binding.decimal.setText("")
    }
}