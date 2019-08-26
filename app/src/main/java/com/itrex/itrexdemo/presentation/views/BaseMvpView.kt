package com.itrex.itrexdemo.presentation.views

import com.arellomobile.mvp.MvpView

interface BaseMvpView : MvpView {
    fun hideKeyboard()
    fun showToast(resId: Int)
}