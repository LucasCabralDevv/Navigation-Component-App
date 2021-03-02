package com.lucascabral.navigationapplication.ui.registration.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.lucascabral.navigationapplication.R
import com.lucascabral.navigationapplication.ui.registration.RegistrationViewModel
import kotlinx.android.synthetic.main.fragment_profile_data.*

class ProfileDataFragment : Fragment() {

    private val registrationViewModel: RegistrationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registrationViewModel.registrationStateEvent.observe(viewLifecycleOwner) { registrationState ->
            when (registrationState) {
                is RegistrationViewModel.RegistrationState.CollectCredentials -> {
                    val name = inputProfileDataName.text.toString()
                    val directions = ProfileDataFragmentDirections
                        .actionProfileDataFragmentToChooseCredentialsFragment(name)
                    findNavController().navigate(directions)
                }
            }
        }
    }
}