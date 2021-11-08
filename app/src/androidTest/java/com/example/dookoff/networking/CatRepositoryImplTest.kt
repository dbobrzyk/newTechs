package com.example.dookoff.networking

import com.example.dookoff.data.FakeCatRepository
import com.example.dookoff.model.domain.CatBreedDomain
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test


class CatRepositoryImplTest{


    lateinit var fakeCatRepository: FakeCatRepository

    @Before
    fun setUp(){
        fakeCatRepository = FakeCatRepository()

        runBlocking {
            (1..10).forEach {
//                fakeCatRepository.addCat(Mockito.mock(CatBreedDomain::class.java))
                fakeCatRepository.addCat(
                    CatBreedDomain("cat no $it","","","","")
                )
            }
        }
    }

    @Test
    fun check_if_cat_list_not_empty(){
        runBlocking {
            val breeds = fakeCatRepository.getCatBreeds()
            assert(breeds.isNotEmpty())
        }
    }

    @Test
    fun check_if_cat_breeds_are_not_empty(){
        runBlocking {
            val breeds = fakeCatRepository.getCatBreeds()
            breeds.forEach {
                assert(it.breed.isNotEmpty())
            }
        }
    }



}