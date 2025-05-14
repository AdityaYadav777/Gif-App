package com.aditya.gif_app.Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aditya.gif_app.ViewModels.HomeViewModel

@Composable
fun SearchBarSection(viewModel: HomeViewModel) {

    var search by remember{
        mutableStateOf("")
    }

    Box(modifier = Modifier.fillMaxWidth()) {

        Row(modifier = Modifier .fillMaxWidth().height(70.dp)

        ) {

            OutlinedTextField(modifier = Modifier.weight(5f),

                value = search, onValueChange = {
                search=it
            })

            IconButton(modifier = Modifier.weight(1f),
                onClick = {

                     viewModel.SearchData(search)

                }) {

                Icon(Icons.Default.Search,null)

            }




        }

    }



}