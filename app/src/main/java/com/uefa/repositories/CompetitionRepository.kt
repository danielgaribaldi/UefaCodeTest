package com.uefa.repositories

import com.uefa.R
import com.uefa.model.UefaTeam

interface CompetitionRepository {

    fun getTeam(): UefaTeam
}

class SuperFakeRepository : CompetitionRepository {

    private val players = arrayListOf(
        UefaTeam.Member(
            name = "Marc-André ter Stegen",
            country = "Germany",
            number = "1",
            role = UefaTeam.Member.Role.GOALKEEPER,
            status = UefaTeam.Member.Status.STARTING_LINE_UP
        ),
        UefaTeam.Member(
            name = "Neto",
            country = "Italy",
            number = "13",
            role = UefaTeam.Member.Role.GOALKEEPER,
            status = UefaTeam.Member.Status.BENCH
        ),
        UefaTeam.Member(
            name = "Ronald Araújo",
            country = "Uruguay",
            number = "4",
            role = UefaTeam.Member.Role.DEFENDER,
            status = UefaTeam.Member.Status.BENCH
        ),
        UefaTeam.Member(
            name = "Clément Lenglet",
            country = "France",
            number = "15",
            role = UefaTeam.Member.Role.DEFENDER,
            status = UefaTeam.Member.Status.BENCH
        ),
        UefaTeam.Member(
            name = "Eric García",
            country = "Spain",
            number = "-",
            role = UefaTeam.Member.Role.DEFENDER,
            status = UefaTeam.Member.Status.STARTING_LINE_UP
        ),
        UefaTeam.Member(
            name = "Óscar Mingueza",
            country = "Spain",
            number = "28",
            role = UefaTeam.Member.Role.DEFENDER,
            status = UefaTeam.Member.Status.BENCH
        ),
        UefaTeam.Member(
            name = "Gerard Piqué",
            country = "Spain",
            number = "3",
            role = UefaTeam.Member.Role.DEFENDER,
            status = UefaTeam.Member.Status.STARTING_LINE_UP
        ),
        UefaTeam.Member(
            name = "Samuel Umtiti",
            country = "France",
            number = "23",
            role = UefaTeam.Member.Role.DEFENDER,
            status = UefaTeam.Member.Status.BENCH
        ),
        UefaTeam.Member(
            name = "Jordi Alba",
            country = "Spain",
            number = "18",
            role = UefaTeam.Member.Role.DEFENDER,
            status = UefaTeam.Member.Status.STARTING_LINE_UP
        ),
        UefaTeam.Member(
            name = "Sergiño Dest",
            country = "U.S.A",
            number = "2",
            role = UefaTeam.Member.Role.DEFENDER,
            status = UefaTeam.Member.Status.STARTING_LINE_UP
        ),
        UefaTeam.Member(
            name = "Emerson Royal",
            country = "Brazil",
            number = "-",
            role = UefaTeam.Member.Role.DEFENDER,
            status = UefaTeam.Member.Status.BENCH
        ),
        UefaTeam.Member(
            name = "Sergi Roberto",
            country = "Spain",
            number = "20",
            role = UefaTeam.Member.Role.DEFENDER,
            status = UefaTeam.Member.Status.BENCH
        ),
        UefaTeam.Member(
            name = "Moussa Wagué",
            country = "Senegal",
            number = "-",
            role = UefaTeam.Member.Role.DEFENDER,
            status = UefaTeam.Member.Status.BENCH
        ),
        UefaTeam.Member(
            name = "Sergio Busquets",
            country = "Spain",
            number = "5",
            role = UefaTeam.Member.Role.MIDFIELDER,
            status = UefaTeam.Member.Status.STARTING_LINE_UP
        ),
        UefaTeam.Member(
            name = "Frenkie de Jong",
            country = "Netherlands",
            number = "21",
            role = UefaTeam.Member.Role.MIDFIELDER,
            status = UefaTeam.Member.Status.STARTING_LINE_UP
        ),
        UefaTeam.Member(
            name = "Pedri",
            country = "Spain",
            number = "16",
            role = UefaTeam.Member.Role.MIDFIELDER,
            status = UefaTeam.Member.Status.STARTING_LINE_UP
        ),
        UefaTeam.Member(
            name = "Ilaix Moriba",
            country = "Spain",
            number = "27",
            role = UefaTeam.Member.Role.MIDFIELDER,
            status = UefaTeam.Member.Status.BENCH
        ),
        UefaTeam.Member(
            name = "Miralem Pjanic",
            country = "Bosnia Herzegovina",
            number = "8",
            role = UefaTeam.Member.Role.MIDFIELDER,
            status = UefaTeam.Member.Status.STARTING_LINE_UP
        ),
        UefaTeam.Member(
            name = "Riqui Puig",
            country = "Spain",
            number = "12",
            role = UefaTeam.Member.Role.MIDFIELDER,
            status = UefaTeam.Member.Status.BENCH
        ),
        UefaTeam.Member(
            name = "Monchu",
            country = "Spain",
            number = "-",
            role = UefaTeam.Member.Role.MIDFIELDER,
            status = UefaTeam.Member.Status.BENCH
        ),
        UefaTeam.Member(
            name = "Philippe Coutinho",
            country = "Brazil",
            number = "14",
            role = UefaTeam.Member.Role.MIDFIELDER,
            status = UefaTeam.Member.Status.BENCH
        ),
        UefaTeam.Member(
            name = "Ansu Fati",
            country = "Spain",
            number = "22",
            role = UefaTeam.Member.Role.FORWARD,
            status = UefaTeam.Member.Status.BENCH
        ),
        UefaTeam.Member(
            name = "Ousmane Dembele",
            country = "France",
            number = "11",
            role = UefaTeam.Member.Role.FORWARD,
            status = UefaTeam.Member.Status.BENCH
        ),
        UefaTeam.Member(
            name = "Antoine Griezmann",
            country = "France",
            number = "7",
            role = UefaTeam.Member.Role.FORWARD,
            status = UefaTeam.Member.Status.STARTING_LINE_UP
        ),
        UefaTeam.Member(
            name = "Memphis Depay",
            country = "Netherlands",
            number = "-",
            role = UefaTeam.Member.Role.FORWARD,
            status = UefaTeam.Member.Status.BENCH
        ),
        UefaTeam.Member(
            name = "Sergio Aguero",
            country = "Argentina",
            number = "-",
            role = UefaTeam.Member.Role.FORWARD,
            status = UefaTeam.Member.Status.STARTING_LINE_UP
        ),
        UefaTeam.Member(
            name = "Martin Braithwaite",
            country = "Denmark",
            number = "9",
            role = UefaTeam.Member.Role.FORWARD,
            status = UefaTeam.Member.Status.BENCH
        ),
        UefaTeam.Member(
            name = "Ronald Koeman",
            country = "Denmark",
            number = "",
            role = UefaTeam.Member.Role.COACH,
            status = UefaTeam.Member.Status.STARTING_LINE_UP
        )
    )
    private val team = UefaTeam(
        name = "Barcelona",
        crestResId = R.drawable.bcn_crest,
        members = players
    )

    override fun getTeam(): UefaTeam {

        return team
    }
}