package com.aditya.gif_app.Screens

import android.widget.ImageView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aditya.gif_app.Components.SearchBarSection
import com.aditya.gif_app.Models.Original
import com.aditya.gif_app.ViewModels.HomeViewModel
import com.bumptech.glide.Glide


@Composable
fun Home(viewModel: HomeViewModel) {

    val data=viewModel._getData.collectAsStateWithLifecycle()
    val textualData=data.value

    Column(modifier = Modifier.fillMaxSize().padding(12.dp),

        horizontalAlignment = Alignment.CenterHorizontally) {
     Spacer(Modifier.height(26.dp))
     SearchBarSection(viewModel)

        if(textualData.isEmpty()){
            CircularProgressIndicator()
        }else
        LazyVerticalGrid(GridCells.Fixed(2)) {
          items(textualData){
              showData(it)
          }
      }


    }
}


@Composable
fun showData(original: Original) {
    Column {

        val context= LocalContext.current

        Card(modifier = Modifier.size(180.dp).padding(12.dp)){
            val view = remember { ImageView(context) }

            // Load Gif with Glide library
            DisposableEffect(context) {
                Glide.with(context)
                    .asGif()
                    .load(original.url)
                    .into(view)
                onDispose {
                    // Cleanup when the composable is disposed
                    Glide.with(context).clear(view)
                }
            }

            // Wrap the ImageView with Compose's View composable
            AndroidView(factory = { view })
        }

    }
}