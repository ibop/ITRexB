package com.itrex.itrexdemo.presentation.activities

import com.itrex.itrexdemo.presentation.fragments.StartFragment

class MainActivity : BaseActivity() {

    override fun openDefaultFragment() {
        openFragment(StartFragment::class.java, null)
    }
}
