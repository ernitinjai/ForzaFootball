package com.forza.team.ui.team

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.forza.team.R
import com.forza.team.databinding.FragmentTeamDetailBinding
import com.forza.team.di.ViewModelFactory
import com.forza.team.ui.viewmodel.TeamDetailViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class TeamDetailFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var teamId: Long? = null
    private lateinit var teamsViewModel: TeamDetailViewModel
    private var viewBinding: FragmentTeamDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        teamId = arguments?.getLong(TEAM_ID)
        teamsViewModel =
            ViewModelProviders.of(this, viewModelFactory).get(TeamDetailViewModel::class.java)
        teamId?.let {
            teamsViewModel.loadTeamDetail(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_team_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupDataBinding(view)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    private fun setupDataBinding(view: View) {
        viewBinding = DataBindingUtil.bind(view)
        viewBinding?.lifecycleOwner = this
        viewBinding?.viewModel = teamsViewModel
        teamsViewModel?.getTeamDetail(teamId!!)?.observe(this, Observer { detail ->
            viewBinding?.teamDetail = detail
        })
    }

    companion object {
        const val TEAM_ID = "TEAM_ID"
    }

}
