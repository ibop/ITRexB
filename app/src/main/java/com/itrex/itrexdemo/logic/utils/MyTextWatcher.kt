package com.itrex.itrexdemo.logic.utils

import android.text.Editable
import android.text.TextWatcher

open class MyTextWatcher : TextWatcher {
    override fun afterTextChanged(s: Editable?) {
        //can be overriden
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        //can be overriden
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        //can be overriden
    }
}