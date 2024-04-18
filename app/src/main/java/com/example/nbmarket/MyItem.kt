package com.example.nbmarket

import android.os.Parcelable
import java.text.DecimalFormat

data class MyItem(val aImage:Int, val aProduct:String, val aIntroduction:String, val aSeller:String,
                  var aPrice:String, val aAddress:String, val aLike:String, val aChat:String)

