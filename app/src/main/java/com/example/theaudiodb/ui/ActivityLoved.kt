package com.example.theaudiodb.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.theaudiodb.R
import com.example.theaudiodb.model.repository.LovedRepository
import com.example.theaudiodb.model.repository.LovedRepositoryResult
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class ActivityLoved : AppCompatActivity() {

    private val lovedRepositoryResult: LovedRepositoryResult by inject()
    private val repository: LovedRepository by inject()


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.loved_activity)
        lifecycleScope.launch {
            repository.getMostLoved()
        }

    }

    private fun observeRepository() {
        when (lovedRepositoryResult) {
            LovedRepositoryResult.Error -> {}
            is LovedRepositoryResult.Success -> {}
        }
    }

}