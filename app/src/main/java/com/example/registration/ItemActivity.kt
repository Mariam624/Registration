package com.example.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.registration.databinding.ActivityItemBinding

class ItemActivity : AppCompatActivity() {
    private var _binding: ActivityItemBinding? = null
    private val binding: ActivityItemBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        _binding=ActivityItemBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.itemListTitle.text=intent.getStringExtra("itemTitle")
        binding.itemListText.text=intent.getStringExtra("itemDesc")

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}