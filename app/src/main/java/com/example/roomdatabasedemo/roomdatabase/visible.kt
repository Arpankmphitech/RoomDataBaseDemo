package com.example.roomdatabasedemo.roomdatabase

import android.util.Log
import android.view.View


fun View.visible() {
    visibility = View.VISIBLE
}


fun String.concateString() {

    var name = this
    var lastName = "Ramani"

//    val result = concat(name, lastName)
//    val result = name.plus(lastName)
    val result1 = "$name  $lastName"

    var fullName = StringBuilder().append(name).append(lastName).toString()
    Log.e("TAG", "concateString:==" + result1)


}


