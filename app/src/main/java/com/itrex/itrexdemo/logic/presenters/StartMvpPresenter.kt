package com.itrex.itrexdemo.logic.presenters

import com.arellomobile.mvp.InjectViewState
import com.itrex.itrexdemo.R
import com.itrex.itrexdemo.presentation.fragments.ListFragment
import com.itrex.itrexdemo.presentation.views.StartMvpView

@InjectViewState
class StartMvpPresenter : BasePresenter<StartMvpView>() {

    /**
     * Clicked 'Next'
     */
    fun onNextClicked(search: String) {
        hideKeyboard()

        if (search.trim().isEmpty()) {
            viewState.setError(R.string.empty_field)
            return
        }

        //open next fragment
        viewState.openListFragment(ListFragment::class.java)
    }

    /**
     * Check if user has input symbols
     */
    fun onTextChanged(searchString: String) {
        if (searchString.trim().isNotEmpty()) {
            viewState.setError(0)
        }
    }

    fun startAnimation() {
        //here can be loading data or sync with backend
        Thread(Runnable {
            Thread.sleep(1000)
            viewState.animateScreen()
        }).start()
    }
}