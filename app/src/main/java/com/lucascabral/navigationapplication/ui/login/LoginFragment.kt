package com.lucascabral.navigationapplication.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputLayout
import com.lucascabral.navigationapplication.R
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.authenticationStateEvent.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                is LoginViewModel.AuthenticationState.InvalidAuthentication -> {
                    val validationFields: Map<String, TextInputLayout> = initValidationFields()
                    authenticationState.fields.forEach { fieldError ->
                        validationFields[fieldError.first]?.error = getString(fieldError.second)
                    }
                }
            }
        })

        buttonLoginSignIn.setOnClickListener {
            val userName = inputLoginUsername.text.toString()
            val password = inputLoginPassword.text.toString()
            viewModel.authentication(userName, password)
        }
    }

    private fun initValidationFields() = mapOf(
        LoginViewModel.INPUT_USERNAME.first to inputLayoutLoginUsername,
        LoginViewModel.INPUT_PASSWORD.first to inputLayoutLoginPassword
    )
}