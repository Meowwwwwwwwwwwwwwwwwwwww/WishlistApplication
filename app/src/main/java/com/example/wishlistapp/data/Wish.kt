package com.example.wishlistapp.data

data class Wish(
    val id :Long = 0L,
    val title:String = "",
    val description:String = ""
)
object dummydata{
    val WishList= listOf(Wish(title = "pen", description = "fountain Pen"),
            Wish(title = "Eraser", description =  " Apsara Eraser"),
            Wish(title="nudes", description = "bhejdo"),
            Wish(title="perfume", description = "Mens")
    )
}