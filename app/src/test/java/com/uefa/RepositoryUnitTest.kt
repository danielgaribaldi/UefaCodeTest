package com.uefa

import com.uefa.repositories.SuperFakeRepository
import org.junit.Test

import org.junit.Assert.*

/**
 * Total useless test since all the data is mocked and is not going to fail but to include something
 */
class RepositoryUnitTest {

    private val repository = SuperFakeRepository()

    @Test
    fun getTeamIsCorrect() {

        assertEquals(repository.getTeam().name, "Barcelona")
    }


    @Test
    fun getTeamFail() {

        assertFalse(repository.getTeam().name== "")
    }
}