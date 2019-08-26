package com.itrex.itrexdemo.logic.presenters

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.arellomobile.mvp.InjectViewState
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.itrex.itrexdemo.R
import com.itrex.itrexdemo.data.PriceModel
import com.itrex.itrexdemo.presentation.views.DetailsMvpView
import java.security.SecureRandom

@InjectViewState
class DetailsPresenter : BasePresenter<DetailsMvpView>() {

    companion object {
        const val ITEM = "item"
    }

    /**
     * Show Data on the screen
     */
    fun initData(args: Bundle?) {
        val priceModel = args?.getParcelable(ITEM) as PriceModel? ?: return

        viewState.setKey(priceModel.key)
        viewState.setValue(priceModel.value)
    }

    /**
     * Generate data for chart
     */
    private fun setDataForChart(
        context: Context?
    ) {
        val values2 = ArrayList<Entry>()

        //generate random data
        val rnd = SecureRandom()
        for (i in 0..20) {
            values2.add(Entry(i.toFloat(), rnd.nextFloat() * 10f))
        }

        (context as Activity).runOnUiThread {
            viewState.setChartUI(values2)
        }
    }


    fun loadData(context: Context?) {
        Thread(Runnable {
            //simulate loading from backend
            Thread.sleep(700)

            //simulate handling answer
            setDataForChart(context)

        }).start()
    }
}