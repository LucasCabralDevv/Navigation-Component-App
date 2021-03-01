package com.lucascabral.navigationapplication.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucascabral.navigationapplication.R

class LoginViewModel : ViewModel() {

    sealed class AuthenticationState {
        object Authenticated : AuthenticationState()
        object Unauthenticated : AuthenticationState()
        class InvalidAuthentication(val fields: List<Pair<String, Int>>) : AuthenticationState()
    }

    private val _authenticationStateEvent = MutableLiveData<AuthenticationState>()
    val authenticationStateEvent: LiveData<AuthenticationState>
    get() = _authenticationStateEvent

    init {
        _authenticationStateEvent.value = AuthenticationState.Unauthenticated
    }

    fun authentication(userName: String, password: String) {
        if (isValidForm(userName, password)) { // Usuário autenticado
            _authenticationStateEvent.value = AuthenticationState.Authenticated
        }
    }

    private fun isValidForm(userName: String, password: String): Boolean {
        val invalidFields = arrayListOf<Pair<String, Int>>()

        if (userName.isEmpty()) {
            invalidFields.add(INPUT_USERNAME)
        }
        if (password.isEmpty()) {
            invalidFields.add(INPUT_PASSWORD)
        }
        if (invalidFields.isNotEmpty()) {
            _authenticationStateEvent.value = AuthenticationState.InvalidAuthentication(invalidFields)
            return false
        }

        return true
    }

    companion object {
        val INPUT_USERNAME = "INPUT_USERNAME" to R.string.login_input_layout_error_invalid_username
        val INPUT_PASSWORD = "INPUT_PASSWORD" to R.string.login_input_layout_error_invalid_password
    }
}