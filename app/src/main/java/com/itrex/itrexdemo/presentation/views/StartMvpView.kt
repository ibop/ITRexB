package com.itrex.itrexdemo.presentation.views

import com.itrex.itrexdemo.presentation.fragments.ListFragment

interface StartMvpView : BaseMvpView{
    fun openListFragment(javaClass: Class<ListFragment>)
    fun setError(errorResId: Int)
    fun animateScreen()
}