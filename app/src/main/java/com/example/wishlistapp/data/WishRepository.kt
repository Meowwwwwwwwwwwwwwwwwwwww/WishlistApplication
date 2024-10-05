package com.example.wishlistapp.data

import kotlinx.coroutines.flow.Flow

class WishRepository( private val wishDao: WishDao) {
    suspend fun addAWish (wish: Wish){
        wishDao.addAWish(wish )
    }

     fun getAllWishes ():Flow<List<Wish>> = wishDao.getAllWishes()

    fun getAWish(id :Long):Flow<Wish> {
        return  wishDao.getWish(id)
    }

     suspend fun deleteAWish (wish: Wish) {
         wishDao.deleteWish(wish)
     }
    suspend fun updateWish (wish: Wish){
        wishDao.updateWish(wish)
    }

     }