package com.forza.team.ui.team

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.forza.team.R
import com.forza.team.di.ViewModelFactory
import com.forza.team.ui.viewmodel.TeamsViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_teams.*
import javax.inject.Inject

class TeamsFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var teamsAdapter: TeamsAdapter
    private lateinit var teamsViewModel: TeamsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        teamsViewModel = ViewModelProviders.of(this, viewModelFactory).get(TeamsViewModel::class.java)
        createAdapter()
        onRefresh()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeTeams()
        swipeRefresh.setOnRefreshListener {
            swipeRefresh.isRefreshing = false
            onRefresh()
        }
    }

    private fun setupAdapter() {
        val itemDecorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecorator)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = teamsAdapter
    }

    private fun createAdapter() {
        teamsAdapter = TeamsAdapter(requireContext(), object : TeamsAdapter.OnItemClickListener {
            override fun onItemClicked(teamId: Long) {
                val bundle = Bundle()
                bundle.putLong(TeamDetailFragment.TEAM_ID, teamId)
                Navigation.findNavController(requireActivity(), R.id.fragment_container)
                    .navigate(R.id.teamDetailFragment, bundle)
            }
        })
    }

    private fun observeTeams() {
        teamsViewModel.getTeams().observe(this, Observer { teams ->
            teamsAdapter.setTeams(teams)
        })
    }

    private fun onRefresh() {
        teamsViewModel.loadTeams()
    }
}
