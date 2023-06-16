package com.example.configuration

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.configuration.theme.AppTheme

class AnimalSelectScreenLarge {
    @Composable
    fun TitleScreen(){
        Text(text = "Select the animals you have on your farm", textAlign = TextAlign.Center, fontSize = 18.sp, color = Color.Black)
    }


    @Composable
    private fun AnimalCards(modifier: Modifier = Modifier, image: Int, animalName: String){
        Card(
            modifier
                .width(250.dp)
                .height(350.dp)
                .padding(top = 20.dp)
                .padding(end = 10.dp)
                .height(60.dp)) {
            Column(modifier.fillMaxSize()) {
                Image(painter = painterResource(id = image), contentDescription = "Picture of a $animalName",
                    contentScale = ContentScale.FillBounds, modifier = modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.4f))
                Row(modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(), verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Text(text = animalName, modifier = modifier.padding(0.dp), color = Color.Black)
                }
            }
        }
    }

    @Preview(showBackground = true, device = "spec:width=1920dp,height=1080dp,dpi=480")
    @Composable
    fun Preview(){
        AppTheme() {
            Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                AnimalCards(image = R.drawable.cow, animalName = "Cow")
            }
        }
    }
}