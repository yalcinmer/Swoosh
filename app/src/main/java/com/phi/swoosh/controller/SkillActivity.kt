package com.phi.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import com.phi.swoosh.utilities.EXTRA_LEAGUE
import com.phi.swoosh.databinding.ActivitySkillBinding
import com.phi.swoosh.utilities.EXTRA_SKILL

class SkillActivity : BaseActivity() {

    private var league = ""
    private var skill = ""
    private lateinit var binding: ActivitySkillBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySkillBinding.inflate(layoutInflater)
        setContentView(binding.root)

        league = intent.getStringExtra(EXTRA_LEAGUE).toString()
    }

    fun onBeginnerClicked(view: View) {
        binding.ballerBtn.isChecked = false
        skill = "beginner"
    }

    fun onBallerClicked(view: View) {
        binding.beginnerBtn.isChecked = false
        skill = "baller"
    }

    fun finishLeague(view: View) {
        if(skill != "") {
            val intent = Intent(this@SkillActivity, FinishActivity::class.java)
            intent.putExtra(EXTRA_LEAGUE, league)
            intent.putExtra(EXTRA_SKILL, skill)
            startActivity(intent)
        } else {
            Toast.makeText(this@SkillActivity, "Please select a skill level", Toast.LENGTH_LONG).show()
        }
    }
}