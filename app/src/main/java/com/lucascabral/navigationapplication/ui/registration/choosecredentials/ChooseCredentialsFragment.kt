package com.lucascabral.navigationapplication.ui.registration.choosecredentials

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.lucascabral.navigationapplication.R
import kotlinx.android.synthetic.main.fragment_choose_credentials.*

class ChooseCredentialsFragment : Fragment() {

    private val args: ChooseCredentialsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choose_credentials, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textChooseCredentialsName.text = getString(R.string.choose_credentials_text_name, args.name)
    }
}