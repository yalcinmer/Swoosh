package com.phi.swoosh.controller

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.phi.swoosh.databinding.ActivityFinishBinding
import com.phi.swoosh.model.Player
import com.phi.swoosh.utilities.EXTRA_PLAYER

@Suppress("DEPRECATION")
class FinishActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)
        binding.searchLeagueText.text = "Looking for ${player?.league} ${player?.skill} league near you..."
    }
}