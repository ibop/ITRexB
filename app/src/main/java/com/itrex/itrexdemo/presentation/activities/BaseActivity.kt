package com.itrex.itrexdemo.presentation.activities

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.inputmethod.InputMethodManager
import com.itrex.itrexdemo.R
import com.itrex.itrexdemo.presentation.fragments.BaseFragment

abstract class BaseActivity  : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResource())
        openDefaultFragment()
        initActions()
    }

    open fun initActions() {
        //can be overriden in subclasses
    }

    open fun getLayoutResource(): Int {
        return R.layout.base_activity_layout
    }

    abstract fun openDefaultFragment()

    open fun hideKeyboard() {
        if (window != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(window.decorView.windowToken, 0)
        }
    }

    @SuppressLint("ResourceType")
    fun openFragment(fragmentClass: Class<out BaseFragment<*,*>>, bundle: Bundle?): BaseFragment<*, *>? {
        try {
            val fragment = createFragment(fragmentClass, bundle)
            val popBackStackTag = fragmentClass.name
            val fragmentName = fragmentClass.name
            val transaction = fragmentManager.beginTransaction()

            transaction.setCustomAnimations(R.anim.enter, R.anim.exit, 0, 0)

            transaction.add(R.id.vContainer, fragment, fragmentName)
            transaction.addToBackStack(popBackStackTag)
            transaction.commit()
            return fragment
        } catch (e: Exception) {
        }
        return null
    }

    @Throws(Exception::class)
    fun createFragment(fragmentClass: Class<out BaseFragment<*, *>>, args: Bundle?): BaseFragment<*, *> {
        val fragment = fragmentClass.newInstance()
        var bundle: Bundle? = args
        if (bundle == null) {
            bundle = Bundle()
        }
        fragment.setHasOptionsMenu(true)
        fragment.setArguments(bundle)
        return fragment
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val countBackStack = fragmentManager.backStackEntryCount
        if (countBackStack <= 0) {
            finish()
            return
        }
    }
}