package com.example.theaudiodb.ui

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.theaudiodb.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class ActivityLoved : AppCompatActivity() {

    private val viewModel: LovedViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loved_activity)

        val album: TextView = this.findViewById(R.id.strAlbum)
        val artist: TextView = this.findViewById(R.id.strArtist)
        val track: TextView = this.findViewById(R.id.strTrack)
        val score: TextView = this.findViewById(R.id.intScore)
        val btn: Button = this.findViewById(R.id.btn)

        btn.setOnClickListener {
            observeViewModel(album, artist, track, score)
            viewModel.mostLovedUpdate()
        }
    }

    private fun observeViewModel(
        album: TextView,
        artist: TextView,
        track: TextView,
        score: TextView
    ) {
        viewModel.lovedList.observe(this) {
            when (it) {
                LovedViewModelResult.Error -> {}
                is LovedViewModelResult.Success -> {
                    album.text = it.lovedItem.strAlbum
                    artist.text = it.lovedItem.strArtist
                    track.text = it.lovedItem.strTrack
                    score.text = it.lovedItem.intScore.toString()
                }
            }
        }
    }

}