package com.lucascabral.navigationapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucascabral.navigationapplication.ui.profile.ProfileFragment
import com.lucascabral.navigationapplication.ui.start.StartFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}