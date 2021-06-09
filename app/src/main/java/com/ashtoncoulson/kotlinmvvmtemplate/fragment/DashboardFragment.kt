package com.ashtoncoulson.kotlinmvvmtemplate.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.ashtoncoulson.kotlinmvvmtemplate.R
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showActionBar()

        button_second.setOnClickListener {
            findNavController().navigate(R.id.action_second_fragment_to_first_fragment)
        }
    }
}