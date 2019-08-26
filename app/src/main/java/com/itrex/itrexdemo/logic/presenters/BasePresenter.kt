package com.itrex.itrexdemo.logic.presenters

import com.arellomobile.mvp.MvpPresenter
import com.itrex.itrexdemo.presentation.views.BaseMvpView

open class BasePresenter<V : BaseMvpView> : MvpPresenter<V>() {

    /**
     * hide soft keyboard
     */
    fun hideKeyboard() {
        viewState.hideKeyboard()
    }

    /**
     * show info toast
     */
    fun showToast(resId: Int) {
        viewState.showToast(resId)
    }
}