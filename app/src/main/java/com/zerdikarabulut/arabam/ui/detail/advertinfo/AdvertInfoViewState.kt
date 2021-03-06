package com.zerdikarabulut.arabam.ui.detail.advertinfo

import android.content.Context
import androidx.core.content.ContextCompat
import com.zerdikarabulut.arabam.R
import com.zerdikarabulut.arabam.data.model.ViewPagerAdvertInfo

data class AdvertInfoViewState(private val advertInfo: ViewPagerAdvertInfo) {

    fun setTextColor(context: Context): Int {
        if (advertInfo.key == context.getString(R.string.advert_price_title)) {
            return ContextCompat.getColor(context, R.color.red)
        } else if (advertInfo.key == context.getString(R.string.advert_no_title)) {
            return ContextCompat.getColor(context, R.color.blue_action)
        }
        return ContextCompat.getColor(context, R.color.text_light_black)
    }

    fun setBackgroundColor(context: Context, isColor: Boolean): Int {
        if (isColor) return ContextCompat.getColor(context, R.color.grey_f0)

        return ContextCompat.getColor(context, R.color.white)
    }
}

