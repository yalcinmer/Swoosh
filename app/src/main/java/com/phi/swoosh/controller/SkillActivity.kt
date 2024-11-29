package com.phi.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.phi.swoosh.databinding.ActivitySkillBinding
import com.phi.swoosh.model.Player
import com.phi.swoosh.utilities.EXTRA_PLAYER

@Suppress("DEPRECATION")
class SkillActivity : BaseActivity() {

    private lateinit var player : Player
    private lateinit var binding: ActivitySkillBinding

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
        binding = ActivitySkillBinding.inflate(layoutInflater)
        setContentView(binding.root)

        player = intent.getParcelableExtra(EXTRA_PLAYER)!!
    }

    fun onBeginnerClicked(view: View) {
        binding.ballerBtn.isChecked = false
        player.skill = "beginner"
    }

    fun onBallerClicked(view: View) {
        binding.beginnerBtn.isChecked = false
        player.skill = "baller"
    }

    fun finishLeague(view: View) {
        if(player.skill != "") {
            val intent = Intent(this@SkillActivity, FinishActivity::class.java)
            intent.putExtra(EXTRA_PLAYER, player)
            startActivity(intent)
        } else {
            Toast.makeText(this@SkillActivity, "Please select a skill level", Toast.LENGTH_LONG).show()
        }
    }
}