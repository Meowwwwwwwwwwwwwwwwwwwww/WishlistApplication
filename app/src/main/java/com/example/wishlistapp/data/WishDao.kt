package com.example.wishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
 abstract class WishDao{

     @Insert(onConflict = OnConflictStrategy.IGNORE)
     abstract suspend fun addAWish(wishEntity: Wish) // suspend fun and FLow does the same job of background processes in synchronous programming

     @Query("Select * from `wish-table`")
     abstract fun getAllWishes () : Flow<List<Wish>> //flow is used for background process or is a part of coroutine/  used in asynchronous programming


     @Update
     abstract  suspend fun updateWish (wishEntity: Wish)

     @Delete
     abstract suspend fun deleteWish(wishEntity: Wish)

     @Query("Select * from `wish-table` where id =:id ")
     abstract fun getWish (id:Long) : Flow<Wish>

 }