package com.example.wishlistapp

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp


@Composable
fun AppBar( title:String,
            onBackNavClicked: ()-> Unit={}){


    val navigationIcon :(@Composable ()->Unit)? =
        if(!title.contains("WishList")){{
        IconButton(onClick = { onBackNavClicked() }) {
            Icon(imageVector = Icons.Filled.ArrowBack,
                tint = Color.White,
                contentDescription = null

            )

            
        }
    }}
    else{
        null
    }



    TopAppBar (title = {
        Text(text = title,
            color = colorResource(id = R.color.white),
            modifier = Modifier
                .padding(start = 2.dp)
                .heightIn(max = 24.dp)

        )

    }, 
        elevation = 24.dp,
        backgroundColor = colorResource(id =R.color.purple_700 ),
       navigationIcon = navigationIcon
        
        
        
    )
}