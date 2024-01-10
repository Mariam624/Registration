package com.example.registration

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registration.databinding.ActivityItemBinding
import com.razorpay.Checkout
import org.json.JSONObject

class ItemActivity : AppCompatActivity() {
    private var _binding: ActivityItemBinding? = null
    private val binding: ActivityItemBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        _binding=ActivityItemBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Checkout.preload(applicationContext)
        val co = Checkout()
        // apart from setting it in AndroidManifest.xml, keyId can also be set
        // programmatically during runtime
        co.setKeyID("rzp_test_DYDdEcFlzbvI9H")

        binding.itemListTitle.text=intent.getStringExtra("itemTitle")
        binding.itemListText.text=intent.getStringExtra("itemDesc")
        binding.itemButtonBuy.setOnClickListener {
            startPayment()
        }

    }
    private fun startPayment() {
        /*
        *  You need to pass the current activity to let Razorpay create CheckoutActivity
        * */
        val activity: Activity = this
        val co = Checkout()

        try {
            val options = JSONObject()
            options.put("name","Mar624")
            options.put("description","Demoing Charges")
            //You can omit the image option to fetch the image from the dashboard
            options.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg")
            options.put("theme.color", "#53436E");
            options.put("currency","AMD");
            options.put("order_id", "order_DBJOWzybf0sJbb");
            options.put("amount","10000")//pass amount in currency subunits




            co.open(activity,options)
        }catch (e: Exception){
            Toast.makeText(activity,"Error in payment: "+ e.message,Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}