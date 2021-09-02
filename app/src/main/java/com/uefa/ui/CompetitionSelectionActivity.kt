package com.uefa.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.uefa.model.UefaCompetitions
import com.uefa.databinding.CompetitionSelectionActivityBinding


class CompetitionSelectionActivity : AppCompatActivity() {

    companion object {
        const val COMPETITION = "com.uefa.COMPETITION"
    }

    private lateinit var viewBinding: CompetitionSelectionActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        viewBinding = CompetitionSelectionActivityBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.buttonUcl.setOnClickListener {
            openCompetition(UefaCompetitions.UCL)
        }

        viewBinding.buttonUel.setOnClickListener {
            openCompetition(UefaCompetitions.UEL)
        }
    }

    private fun openCompetition(competition: UefaCompetitions) {
        startActivity(Intent(this, CompetitionActivity::class.java).apply {
            putExtra(COMPETITION, competition)
        })
    }
}