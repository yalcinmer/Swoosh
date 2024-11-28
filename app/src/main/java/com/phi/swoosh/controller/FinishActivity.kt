package com.phi.swoosh.controller

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.phi.swoosh.R
import com.phi.swoosh.databinding.ActivityFinishBinding
import com.phi.swoosh.utilities.EXTRA_LEAGUE
import com.phi.swoosh.utilities.EXTRA_SKILL

class FinishActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val league = intent.getStringExtra(EXTRA_LEAGUE)
        val skill = intent.getStringExtra(EXTRA_SKILL)
        binding.searchLeagueText.text = "Looking for $league $skill league near you..."
    }
}