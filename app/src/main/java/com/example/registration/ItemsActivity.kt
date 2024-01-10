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
        items.add(Item(1,"sofa","Sofa", "A sofa designed to redefine the way you lounge.","The upholstery comes in a wide range of fabrics and leathers with special couture details: decorative, matching or contrasting blanket stitching for the fabric versions, and elegant “envelope stitching” for the leather ones. The feet are either covered in fabric or leather or available in a shellac finish.", 200))
        items.add(Item(2,"chandelier","Chandelier", " The spherical orb shade, highly mirrored and perfectly reflective, reveals a multiplicity of internal reflections from the integral LED when switched on. ","Brighten up your room with Cooper chandelier that has black and gold finish and offers 6 luminous lights. It has contemporary and modern style that looks good in any concept of your house.", 100))
        items.add(Item(3,"furniture","Furniture", "descrription3","text3", 500))

        binding.itemsList.layoutManager=LinearLayoutManager(this)
        binding.itemsList.adapter=ItemsAdapter(items,this)
    }
}