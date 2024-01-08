package com.example.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.registration.databinding.ActivityItemsBinding
import com.example.registration.databinding.ActivityMainBinding

class ItemsActivity : AppCompatActivity() {
    private var _binding:ActivityItemsBinding?=null
    private val binding: ActivityItemsBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding=ActivityItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val items= arrayListOf<Item>()
        items.add(Item(1,"sofa","title1", "descrription1","text1", 200))
        items.add(Item(2,"chandelier","title2", "descrription2","text2", 100))
        items.add(Item(3,"furniture","title3", "descrription3","text3", 500))

        binding.itemsList.layoutManager=LinearLayoutManager(this)
        binding.itemsList.adapter=ItemsAdapter(items,this)
    }
}