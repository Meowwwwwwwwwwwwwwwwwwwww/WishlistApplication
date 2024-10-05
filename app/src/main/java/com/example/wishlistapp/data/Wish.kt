package com.example.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id :Long = 0L,
    @ColumnInfo("wish-title")
    val title:String = "",
    @ColumnInfo("Wish-desc")
    val description:String = ""
)


object dummydata{
    val WishList= listOf(Wish(title = "pen", description = "fountain Pen"),
            Wish(title = "Eraser", description =  " Apsara Eraser"),
          
            Wish(title="perfume", description = "Mens")
    )
}