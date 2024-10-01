package com.example.wishlistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun AddEditDetails(viewModel: WishVIewModel,
                    id:Long,
                    navController: NavController
                    ){
                 Scaffold(topBar = {AppBar(title = if (id!=0L) stringResource(id = R.string.update_wish)
                 else stringResource(id = R.string.add_wish)
                 ) { navController.navigate(Screen.HomeScreen.route) }

                 }) {
                  Column (modifier = Modifier
                      .padding(it)
                      .wrapContentSize(),
                      horizontalAlignment = Alignment.CenterHorizontally,
                      verticalArrangement = Arrangement.Center
                      ){
                      Spacer(modifier = Modifier.height(10.dp))

                      WishTextField(label = "Title",
                          description =viewModel.titleState ,
                          onValueChange = {
                              viewModel.onTitleChanged(it)})


                     Spacer(modifier = Modifier.height(10.dp))

                     WishTextField(label = "Description",
                         description =viewModel.descriptionState ,
                         onValueChange ={
                             viewModel.onDescriptionChanged(it)
                         } )
                     Spacer(modifier = Modifier.height(10.dp))
                     
                     Button(onClick = {
                         if (viewModel.descriptionState.isNotEmpty() &&
                             viewModel.titleState.isNotEmpty()
                         ) {
                             //updateList
                         } else {
                             //AddList
                         } }
                     ) {
                         Text(text =
                             if (id != 0L) stringResource(id = R.string.update_wish) else stringResource(R.string.add_wish)
                        , style = TextStyle(
                            fontSize = 18.sp
                        ) )

                     }
                 }}
                     
}

@Composable
fun WishTextField( label:String,
                   description:String,
                   onValueChange:(String)->Unit){
  OutlinedTextField(
      value = description,
      onValueChange = onValueChange,
      label = {
          Text(text = label, color = Color.Black)
      },
      modifier=Modifier.fillMaxWidth(),
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
      colors = TextFieldDefaults.outlinedTextFieldColors(
          textColor = colorResource(id =R.color.black ),



          cursorColor= colorResource(id =R.color.black ),

          focusedBorderColor= colorResource(id =R.color.black ),
          unfocusedBorderColor= colorResource(id =R.color.black ),
          focusedLabelColor =colorResource(id =R.color.black ) ,
          unfocusedLabelColor = colorResource(id =R.color.black )

      )

      )

}