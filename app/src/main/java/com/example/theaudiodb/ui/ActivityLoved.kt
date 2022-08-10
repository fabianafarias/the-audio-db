package com.example.theaudiodb.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.theaudiodb.R
import org.koin.android.ext.android.inject

class ActivityLoved : AppCompatActivity() {

    private val viewModel: LovedViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.loved_activity)

        observeViewModel()
        viewModel.mostLovedUpdate()
    }

    private fun observeViewModel() {
        viewModel.lovedList.observe(this) {
            when (it) {
                LovedViewModelResult.Error -> {}
                is LovedViewModelResult.Success -> {
                    Log.d("TAG", "${it.lovedItem}")
                }
            }
        }
    }

}