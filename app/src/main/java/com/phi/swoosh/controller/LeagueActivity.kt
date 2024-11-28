package com.phi.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.phi.swoosh.utilities.EXTRA_LEAGUE
import com.phi.swoosh.databinding.ActivityLeagueBinding

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""
    private lateinit var binding: ActivityLeagueBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLeagueBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun leagueNextClick(view: View) {
        if(selectedLeague != "") {
            val skillActivity = Intent(this@LeagueActivity, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this@LeagueActivity, "Please select a league!", Toast.LENGTH_LONG).show()
        }
    }

    fun onWomensClicked(view: View) {
        binding.mensLeagueBtn.isChecked = false
        binding.coedLeagueBtn.isChecked = false
        selectedLeague = "womens"
    }

    fun onMensClicked(view: View) {
        binding.womensLeagueBtn.isChecked = false
        binding.coedLeagueBtn.isChecked = false
        selectedLeague = "mens"
    }

    fun onCoEdClicked(view: View) {
        binding.womensLeagueBtn.isChecked = false
        binding.mensLeagueBtn.isChecked = false
        selectedLeague = "coed"
    }
}