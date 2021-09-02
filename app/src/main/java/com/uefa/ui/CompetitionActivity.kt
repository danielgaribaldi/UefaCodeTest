package com.uefa.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.uefa.R
import com.uefa.ui.CompetitionSelectionActivity.Companion.COMPETITION
import com.uefa.model.UefaCompetitions
import com.uefa.databinding.CompetitionActivityBinding
import com.uefa.viewmodels.CompetitionActivityViewModel


class CompetitionActivity : AppCompatActivity() {

    private val viewModel: CompetitionActivityViewModel by viewModels()

    private lateinit var viewBinding: CompetitionActivityBinding
    private lateinit var viewPagerAdapter: CompetitionViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setCompetitionTheme()

        setUpViewBinding()

        setUpToolbar()

        setUpObservers()

        viewModel.getTeam()
    }

    private fun setUpObservers() {

        viewModel.team.observe(this) {

            viewBinding.toolbarContent.teamName.text = it.name
            viewBinding.toolbarContent.crest.setImageResource(it.crestResId)

            setUpViewPager()
        }
    }

    private fun setUpViewPager() {

        viewPagerAdapter = CompetitionViewPagerAdapter(this)
        viewBinding.content.pager.adapter = viewPagerAdapter

        TabLayoutMediator(
            viewBinding.content.tabLayout,
            viewBinding.content.pager
        ) { tab, position ->
            tab.text = getString(viewPagerAdapter.getResIdForTab(position))
        }.attach()
    }

    private fun setUpViewBinding() {

        viewBinding = CompetitionActivityBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }

    private fun setUpToolbar() {

        setSupportActionBar(viewBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = ""
    }

    private fun setCompetitionTheme() {

        when (intent.getSerializableExtra(COMPETITION) as UefaCompetitions) {
            UefaCompetitions.UCL -> setTheme(R.style.Theme_UefaTest_Ucl)
            UefaCompetitions.UEL -> setTheme(R.style.Theme_UefaTest_Uel)
        }
    }
}

private class CompetitionViewPagerAdapter(fragment: FragmentActivity) :
    FragmentStateAdapter(fragment) {

    private enum class TABS(val nameResId: Int) {
        OVERVIEW(R.string.overview_tab),
        MATCHES(R.string.matches_tab),
        GROUPS(R.string.groups_tab),
        STATS(R.string.stats_tab),
        SQUAD(R.string.squad_tab)
    }

    override fun getItemCount() = TABS.values().size

    override fun createFragment(position: Int): Fragment {

        return when (TABS.values()[position]) {
            TABS.OVERVIEW,
            TABS.MATCHES,
            TABS.GROUPS,
            TABS.STATS -> EmptyFragment()
            TABS.SQUAD -> SquadStatsFragment()
        }
    }

    fun getResIdForTab(tabPosition: Int): Int {

        return TABS.values()[tabPosition].nameResId
    }
}