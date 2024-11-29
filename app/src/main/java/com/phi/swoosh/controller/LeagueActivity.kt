package com.phi.swoosh.controller

import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.phi.swoosh.databinding.ActivityLeagueBinding
import com.phi.swoosh.model.Player
import com.phi.swoosh.utilities.EXTRA_PLAYER

@Suppress("DEPRECATION")
class LeagueActivity : BaseActivity() {

    private var player = Player("", "")

    private lateinit var binding: ActivityLeagueBinding

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState.getParcelable(EXTRA_PLAYER)!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLeagueBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun leagueNextClick(view: View) {
        if(player.league != "") {
            val skillActivity = Intent(this@LeagueActivity, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this@LeagueActivity, "Please select a league!", Toast.LENGTH_LONG).show()
        }
    }

    fun onWomensClicked(view: View) {
        binding.mensLeagueBtn.isChecked = false
        binding.coedLeagueBtn.isChecked = false
        player.league = "womens"
    }

    fun onMensClicked(view: View) {
        binding.womensLeagueBtn.isChecked = false
        binding.coedLeagueBtn.isChecked = false
        player.league = "mens"
    }

    fun onCoEdClicked(view: View) {
        binding.womensLeagueBtn.isChecked = false
        binding.mensLeagueBtn.isChecked = false
        player.league = "coed"
    }
}