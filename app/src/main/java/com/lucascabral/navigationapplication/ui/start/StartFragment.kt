package com.lucascabral.navigationapplication.ui.start

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lucascabral.navigationapplication.R
import kotlinx.android.synthetic.main.fragment_start.*

class StartFragment : Fragment() {

    private lateinit var listener: OnButtonClicked

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonStart.setOnClickListener {
            listener.buttonClicked()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnButtonClicked) {
            listener = context
        }
    }

    companion object {
        fun newInstance(): StartFragment = StartFragment()
    }

    interface OnButtonClicked {
        fun buttonClicked()
    }
}