package com.ashtoncoulson.kotlinmvvmtemplate.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.ashtoncoulson.kotlinmvvmtemplate.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideActionBar()

        loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_login_to_dashboard)
        }
    }
}