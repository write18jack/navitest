package com.example.navitest.adapter

import android.widget.ImageButton
import androidx.databinding.BindingAdapter
import com.example.navitest.R

object CommonBindingAdapter {

    @JvmStatic
    @BindingAdapter("app:iconId")
    fun setIconById(view: ImageButton, iconId: Int){

        val resourceId = when(iconId){
            1 -> R.drawable.felix
            2 -> R.drawable.griezmann
            else -> null
        }

        resourceId?.let{
            view.setImageResource(it)
        }?: view.setImageDrawable(null)
    }
}