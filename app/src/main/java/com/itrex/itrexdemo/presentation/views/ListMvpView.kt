package com.itrex.itrexdemo.presentation.views

import com.itrex.itrexdemo.data.PriceModel
import java.util.ArrayList

interface ListMvpView : BaseMvpView {
    fun showListData(listData: ArrayList<PriceModel>)
}