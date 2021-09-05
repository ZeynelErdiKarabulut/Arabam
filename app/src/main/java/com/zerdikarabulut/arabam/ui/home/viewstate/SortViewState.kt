package com.zerdikarabulut.arabam.ui.home.viewstate

import android.app.AlertDialog
import android.content.Context
import android.view.View
import com.zerdikarabulut.arabam.data.mock.Mock
import com.zerdikarabulut.arabam.ui.adapter.AdvertSortAdapter
import com.zerdikarabulut.arabam.ui.home.HomeViewModel

data class SortViewState(
    private val context: Context,
    private val alert: AlertDialog,
    private val homeViewModel: HomeViewModel
) {

    fun alertClose(view: View) {
        alert.dismiss()
    }

    fun adapter(): AdvertSortAdapter {
        return AdvertSortAdapter(Mock.getSortList(context)) {
            homeViewModel.sortResult(it, context, null)
        }
    }
}