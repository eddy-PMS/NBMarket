package com.example.nbmarket

import android.content.DialogInterface
import android.graphics.Paint
import android.graphics.Paint.UNDERLINE_TEXT_FLAG
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nbmarket.databinding.ActivitySecondBinding
import java.text.DecimalFormat

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setContentView(binding.root)

        binding.secondleftbutton.setOnClickListener {
            finish()
        }

        binding.secondEndbutton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("종료")
            builder.setMessage("정말 종료하시겠습니까?")
            builder.setIcon(R.drawable.chat)

            val dialogButton = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when (p1) {
                        DialogInterface.BUTTON_POSITIVE ->
                            finish()
                    }
                }
            }
            builder.setPositiveButton("확인", dialogButton)
            builder.setNegativeButton("취소", null)

            builder.show()
        }

        val image = intent.getIntExtra("dataImage", 0)
        binding.secondImageView.setImageResource(image)

        val product = intent.getStringExtra("dataProduct")
        binding.secondProductTextView.text = product

        val introduction = intent.getStringExtra("dataIntroduction")
        binding.secondIntroductionTextView.text = introduction

        val seller = intent.getStringExtra("dataSeller")
        binding.secondSellerTextView.text = seller

        val price = intent.getStringExtra("dataPrice")
        val priceInt = price?.toIntOrNull() ?: 0
        val priceComma = addCommas(priceInt)
        binding.seconPriceTextView.text = "${priceComma}원"

        val address = intent.getStringExtra("dataAddress")
        binding.secondAddressTextView.text = address


    }
    fun addCommas(number: Int): String {
        val formatter = DecimalFormat("#,###,###")
        return formatter.format(number.toLong())
    }

//    val priceComma = addCommas(mItems[position].aPrice.toInt())
//    holder.price.text = "${priceComma}원"
}