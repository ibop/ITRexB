package com.itrex.itrexdemo.presentation.views

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import java.util.ArrayList

interface DetailsMvpView : BaseMvpView {
    fun setKey(key: String)
    fun setValue(value: Float)
    fun showFields(description: Int)
    fun showChartData(
        data: LineData,
        fl: Float,
        fl1: Float
    )

    fun setChartUI(values2: ArrayList<Entry>)
}