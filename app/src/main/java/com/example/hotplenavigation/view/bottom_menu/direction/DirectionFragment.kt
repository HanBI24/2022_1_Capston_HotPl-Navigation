package com.example.hotplenavigation.view.bottom_menu.direction

import android.app.Activity
import android.widget.Toast
import com.example.hotplenavigation.R
import com.example.hotplenavigation.base.BindingFragment
import com.example.hotplenavigation.databinding.FragmentDirectionBinding
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DirectionFragment : BindingFragment<FragmentDirectionBinding>(R.layout.fragment_direction) {

    override fun initView() {

    }
}
