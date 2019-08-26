package com.itrex.itrexdemo.logic.presenters

import com.arellomobile.mvp.InjectViewState
import com.itrex.itrexdemo.data.PriceModel
import com.itrex.itrexdemo.presentation.views.ListMvpView
import java.security.SecureRandom
import java.util.ArrayList

@InjectViewState
class ListPresenter : BasePresenter<ListMvpView>() {

    private val validChars = "abcdefghijklmnopqrstuvwxyz"
    private var rnd = SecureRandom()

    /**
     * get random string with length
     */
    private fun randomString(len: Int): String {
        val sb = StringBuilder(len)
        for (i in 0 until len)
            sb.append(validChars[rnd.nextInt(validChars.length)])
        return sb.toString()
    }

    /**
     * Generate random list data
     */
    private fun getListData(): ArrayList<PriceModel> {

        val list = ArrayList<PriceModel>()
        for (i in 0..30) {
            list.add(
                PriceModel(
                    randomString(rnd.nextInt(2) + 2),
                    rnd.nextFloat() * 1000f,
                    rnd.nextBoolean()
                )
            )
        }
        return list
    }

    fun initList() {
        viewState.showListData(getListData())
    }
}