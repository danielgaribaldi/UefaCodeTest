package com.uefa.ui

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.uefa.R
import com.uefa.model.UefaTeam
import com.uefa.databinding.SquadStatsFragmentBinding
import com.uefa.databinding.TeamLineFragmentBinding
import com.uefa.viewmodels.CompetitionActivityViewModel

class SquadStatsFragment : Fragment() {

    private var _viewBinding: SquadStatsFragmentBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: CompetitionActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = SquadStatsFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.bench.text =
            viewModel.team.value?.members?.filter { it.status == UefaTeam.Member.Status.BENCH }
                ?.joinToString(separator = ", ") { it.name }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

}

@Suppress("unused")
class TeamLineFragment : Fragment() {

    private val viewModel: CompetitionActivityViewModel by activityViewModels()

    private var _viewBinding: TeamLineFragmentBinding? = null
    private val viewBinding get() = _viewBinding!!

    private var role: UefaTeam.Member.Role = UefaTeam.Member.Role.FORWARD

    private lateinit var adapter: TeamLineListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = TeamLineFragmentBinding.inflate(inflater, container, false)

        adapter = TeamLineListAdapter()

        viewBinding.line.text = getString(role.nameResId)

        viewBinding.recycler.layoutManager = LinearLayoutManager(context)
        viewBinding.recycler.adapter = adapter

        adapter.submitList(
            viewModel.team.value?.getTeamLine(
                role,
                UefaTeam.Member.Status.STARTING_LINE_UP
            )
        )

        return viewBinding.root
    }

    override fun onInflate(context: Context, attrs: AttributeSet, savedInstanceState: Bundle?) {
        super.onInflate(context, attrs, savedInstanceState)

        val a = context.obtainStyledAttributes(attrs, R.styleable.com_uefa_ui_TeamLineFragment)
        val positionString = a.getText(R.styleable.com_uefa_ui_TeamLineFragment_teamLine).toString()
        role = UefaTeam.Member.Role.valueOf(positionString)

        a.recycle()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}

private class TeamLineListAdapter :
    ListAdapter<UefaTeam.Member, TeamLineListAdapter.TeamLineItemViewHolder>(object :
        DiffUtil.ItemCallback<UefaTeam.Member>() {

        override fun areItemsTheSame(oldItem: UefaTeam.Member, newItem: UefaTeam.Member): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(
            oldItem: UefaTeam.Member,
            newItem: UefaTeam.Member
        ): Boolean {
            return oldItem == newItem
        }
    }) {

    class TeamLineItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val playerName = itemView.findViewById<TextView>(R.id.player_name)
        private val playerCountry = itemView.findViewById<TextView>(R.id.player_country)
        private val playerNumber = itemView.findViewById<TextView>(R.id.player_number)
        private val playerAvatar = itemView.findViewById<ShapeableImageView>(R.id.player_image)

        fun setPlayer(member: UefaTeam.Member) {

            playerName.text = member.name
            playerCountry.text = member.country
            playerNumber.text = member.number
            playerAvatar.setImageResource(R.drawable.default_avatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TeamLineItemViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.squad_item_layout, parent, false)
    )

    override fun onBindViewHolder(holder: TeamLineItemViewHolder, position: Int) {
        holder.setPlayer(getItem(position))
    }
}
