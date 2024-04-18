package com.example.nbmarket

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyItem(val aImage:Int, val aProduct:String, val aIntroduction:String, val aSeller:String,
                  var aPrice:String, val aAddress:String, val aLike:String, val aChat:String)
    :Parcelable

