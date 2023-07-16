package com.linoop.openinapp.presentation.views

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.linoop.openinapp.R
import com.linoop.openinapp.databinding.ActivityMainBinding
import com.linoop.openinapp.databinding.LayoutMessageBinding
import com.linoop.openinapp.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun showMessage(title: String, message: String) {
        runOnUiThread {
            val dialogBuilder = MaterialAlertDialogBuilder(this)
            val dialogView = LayoutInflater.from(this).inflate(R.layout.layout_message, null)
            val dialogBinding = LayoutMessageBinding.bind(dialogView)
            dialogBuilder.setView(dialogBinding.root)
            dialogBuilder.background = ColorDrawable(Color.TRANSPARENT)
            dialogBuilder.setCancelable(false)
            val dialog = dialogBuilder.create()
            dialogBinding.title.text = title
            dialogBinding.message.text = message
            dialogBinding.buttonYes.text = getString(R.string.ok)
            dialogBinding.buttonYes.setOnClickListener { dialog.dismiss() }
            dialogBinding.buttonNo.visibility = View.GONE
            dialog.show()
        }
    }
}