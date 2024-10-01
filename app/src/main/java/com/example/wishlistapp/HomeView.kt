package com.example.wishlistapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wishlistapp.data.Wish
import com.example.wishlistapp.data.dummydata

@Composable
fun HomeView(viewModel: WishVIewModel,
             navController: NavController
             ){
    val context= LocalContext.current
    Scaffold(
        topBar = {AppBar(title="WishList"
        )},


        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screen.AddScreen.route)}
                    ,
                modifier=Modifier.padding(all = 24.dp),
                contentColor = Color.White,
                backgroundColor =Color.Blue
            ) {
                 Icon(imageVector = Icons.Filled.Add, contentDescription =  null)
            }

        }
    ) {
          LazyColumn( modifier = Modifier
              .fillMaxSize()
              .padding(it)){
              items(dummydata.WishList) { wish -> wishItem(wish=wish,{}) }

          }
    }
}
@Composable
fun wishItem(wish: Wish, onClicked:()->Unit) {
    Card(modifier = Modifier
        .padding(start = 8.dp, end = 8.dp, top = 8.dp)
        .fillMaxWidth()
        .clickable {
            onClicked()
        },
        elevation = 10.dp,
        backgroundColor = Color.White
        ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description, fontWeight = FontWeight.Medium)
        }

    }

}