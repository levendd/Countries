package com.levojuk.countries.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.levojuk.countries.R

fun ImageView.downloadFromUrl(url :String?,progressDrawable :CircularProgressDrawable){
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher_round)
    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)

}
fun placeHolderProgressBar(contex :Context):CircularProgressDrawable{
    return CircularProgressDrawable(contex).apply {

        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}