package com.forza.team.ui.team

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.forza.api.model.Team
import com.forza.team.R
import com.forza.team.databinding.TeamItemBinding

class TeamsAdapter(private val context: Context, val clickListener: OnItemClickListener) :
    RecyclerView.Adapter<TeamsAdapter.ViewHolder>() {

    private val teams = ArrayList<Team>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.team_item, parent, false)
        return ViewHolder(DataBindingUtil.bind(itemView)!!)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(teams[position])
    }

    fun setTeams(teams: List<Team>) {
        this.teams.clear()
        this.teams.addAll(teams)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return this.teams.size
    }

    inner class ViewHolder(private val teamItemBinding: TeamItemBinding) :
        RecyclerView.ViewHolder(teamItemBinding.root) {

        fun bind(team: Team) {
            teamItemBinding.team = team
            teamItemBinding.itemClickListener = clickListener
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(teamId: Long)
    }
}
