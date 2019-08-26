package com.itrex.itrexdemo.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.support.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.arellomobile.mvp.MvpFragment
import com.itrex.itrexdemo.logic.presenters.BasePresenter
import com.itrex.itrexdemo.presentation.activities.BaseActivity
import com.itrex.itrexdemo.presentation.views.BaseMvpView

abstract class BaseFragment<V : BaseMvpView, P : BasePresenter<V>> : MvpFragment(),
    BaseMvpView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    fun openFragment(fragmentClass: Class<out BaseFragment<*, *>>) {
        openFragment(fragmentClass, null)
    }

    fun openFragment(fragmentClass: Class<out BaseFragment<*, *>>, bundle: Bundle?) {
        (activity as BaseActivity).openFragment(fragmentClass, bundle)
    }

    abstract fun getLayoutId(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initActions()
    }

    abstract fun initActions()

    override fun hideKeyboard() {
        (activity as BaseActivity).hideKeyboard()
    }

    open fun animate(viewGroup: ViewGroup?) {
        if (viewGroup != null) {
            TransitionManager.beginDelayedTransition(viewGroup)
        }
    }

    /**
     * Show toast message
     */
    override fun showToast(resId: Int) {
        Toast.makeText(
            activity as Context,
            getString(resId),
            Toast.LENGTH_SHORT
        ).show()
    }
}