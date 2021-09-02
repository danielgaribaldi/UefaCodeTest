package com.uefa.model

import android.os.Parcelable
import com.uefa.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class UefaTeam(
    val name: String,
    val crestResId: Int,
    val members: ArrayList<Member>
) : Parcelable {

    @Parcelize
    data class Member(
        val name: String,
        val number: String = "",
        val country: String,
        val avatar: String = "",
        val role: Role,
        val status: Status
    ) : Parcelable {

        enum class Role(val nameResId: Int) {
            GOALKEEPER(R.string.goalkeepers),
            DEFENDER(R.string.defenders),
            MIDFIELDER(R.string.midfielders),
            FORWARD(R.string.forwards),
            COACH(R.string.coach)
        }

        enum class Status { STARTING_LINE_UP, BENCH }
    }

    fun getTeamLine(role: Member.Role, status: Member.Status): List<Member>{

        return members.filter { it.role == role && it.status == status }
    }
}