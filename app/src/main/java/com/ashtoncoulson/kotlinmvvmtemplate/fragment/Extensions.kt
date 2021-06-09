package com.ashtoncoulson.kotlinmvvmtemplate.fragment

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.ashtoncoulson.kotlinmvvmtemplate.MainActivity

fun Fragment.hideKeyboard() {
    activity?.currentFocus?.let { view ->
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun Fragment.hideActionBar() {
    (activity as MainActivity).hideActionBar()
}

fun Fragment.showActionBar() {
    (activity as MainActivity).showActionBar()
}