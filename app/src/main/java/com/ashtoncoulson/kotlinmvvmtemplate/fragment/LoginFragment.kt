package com.ashtoncoulson.kotlinmvvmtemplate.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.ashtoncoulson.kotlinmvvmtemplate.R
import com.ashtoncoulson.kotlinmvvmtemplate.model.State
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideActionBar()

        val state = State.WEST_VIRGINIA

        textview_first.text = when (state) {
            State.ALABAMA -> State.ALABAMA.name
            State.COLORADO -> State.COLORADO.postalCode
            State.WEST_VIRGINIA -> State.WEST_VIRGINIA.displayName
            else -> "aint no state"
        }

        button_first.setOnClickListener {
            findNavController().navigate(R.id.action_first_fragment_to_second_fragment)
        }
    }
}