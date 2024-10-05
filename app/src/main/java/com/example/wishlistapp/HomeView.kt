package com.example.wishlistapp

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberDismissState



import androidx.compose.material3.ExperimentalMaterial3Api



import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wishlistapp.data.Wish
import com.example.wishlistapp.data.dummydata


@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@SuppressLint("SuspiciousIndentation")
@Composable
fun HomeView(viewModel: WishVIewModel,
             navController: NavController
             ){
    val context= LocalContext.current
    Scaffold(
        topBar = {AppBar(title="WishList"
        )},


        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screen.AddScreen.route +"/0L")},
                modifier=Modifier.padding(all = 24.dp),
                contentColor = Color.White,
                backgroundColor =Color.Blue
            ) {
                 Icon(imageVector = Icons.Filled.Add, contentDescription =  null)
            }

        }
    ) {
        val wishdata= viewModel.getAllWishes.collectAsState(initial = listOf())
          LazyColumn( modifier = Modifier
              .fillMaxSize()
              .padding(it)){
              items(wishdata.value,key = {wish-> wish.id}) {
                  wish ->
                  val dismissState= rememberDismissState(
                      confirmStateChange ={
                          if (it == DismissValue.DismissedToStart || it==DismissValue.DismissedToEnd){
                              viewModel.deleteAWish(wish)
                          }
                          true
                      }



                  )
                  SwipeToDismiss(state = dismissState ,
                      background ={
                                  val color= animateColorAsState(if (dismissState.dismissDirection == DismissDirection.EndToStart) Color.Blue else Color.Transparent
                                               , label = "" )
                                  val alignment = Alignment.CenterEnd
                                  Box(modifier = Modifier
                                      .fillMaxSize()
                                      .background(color = color.value)
                                      .padding(horizontal = 20.dp),
                                      contentAlignment = alignment)
                                  {
                                    Icon(imageVector = Icons.Default.Delete,
                                         contentDescription ="DeleteIcon",
                                          tint=Color.White )
                          }
                                  } ,

                      directions =  setOf(DismissDirection.EndToStart),
                      dismissThresholds = {FractionalThreshold(0.25f)},
                      dismissContent = {
                          wishItem(wish=wish){

                              val id =wish.id
                              navController.navigate(Screen.AddScreen.route + "/$id")

                          }
                      }
                  )






              }

          }
    }
}
@Composable
fun wishItem(wish: Wish, onClicked:()->Unit) {
    Card(modifier = Modifier
        .padding(start = 8.dp, end = 8.dp, top = 8.dp)
        .fillMaxWidth()
        .clickable { onClicked() },
        elevation = 10.dp,
        backgroundColor = Color.White
        ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
            Text(text = wish.description, fontWeight = FontWeight.Medium)
        }

    }

}