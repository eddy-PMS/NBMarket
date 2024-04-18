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
        fun addCommas(number: Int): String {
            val formatter = DecimalFormat("#,###,###")
            return formatter.format(number.toLong())
        }


        intent.getParcelableExtra("dataList") as? MyItem
        val myItem: MyItem? = intent.getParcelableExtra("dataList") as? MyItem

        myItem?.let { item ->
            val aImage: Int = item.aImage
            val aProduct: String = item.aProduct
            val aIntroduction: String = item.aIntroduction
            val aSeller: String = item.aSeller
            val aPrice: String = item.aPrice
            val aAddress: String = item.aAddress
            val aLike: String = item.aLike
            val aChat: String = item.aChat
            binding.secondImageView.setImageResource(aImage)
            binding.secondProductTextView.text = aProduct
            binding.secondIntroductionTextView.text = aIntroduction
            binding.secondSellerTextView.text = aSeller
            val priceInt = aPrice?.toIntOrNull() ?: 0
            val priceComma = addCommas(priceInt)
            binding.seconPriceTextView.text = "${priceComma}원"
            binding.secondAddressTextView.text = aAddress
        }
    }
}
