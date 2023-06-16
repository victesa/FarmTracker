package com.example.configuration

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.configuration.theme.AppTheme


class AnimalSelectScreenCompact {

    var fourLeggedAnimalData: MutableList<Pair<Int, String>> = mutableListOf()
    var threeLeggedAnimalData: MutableList<Pair<Int, String>> = mutableListOf()

    @Composable
    fun AnimalSelectScreenCompactScreen(modifier: Modifier = Modifier){
        fourLeggedAnimalData.add(Pair(R.drawable.cow, "Cow"))
        fourLeggedAnimalData.add(Pair(R.drawable.goat, "Goat"))
        fourLeggedAnimalData.add(Pair(R.drawable.buffalo, "Buffalo"))
        fourLeggedAnimalData.add(Pair(R.drawable.sheep, "Sheep"))
        fourLeggedAnimalData.add(Pair(R.drawable.pig, "Pig"))

        threeLeggedAnimalData.add(Pair(R.drawable.chicken, "Chicken"))
        threeLeggedAnimalData.add(Pair(R.drawable.goose, "Goose"))
        threeLeggedAnimalData.add(Pair(R.drawable.duck, "Duck"))
        threeLeggedAnimalData.add(Pair(R.drawable.turkey, "Turkey"))




        Column(
            modifier
                .fillMaxWidth()
                .fillMaxHeight(.9f)
                .padding(horizontal = 16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Top()
            Spacer(modifier = modifier.height(30.dp))
            FourLeggedAnimalComposable()
            Spacer(modifier = modifier.height(30.dp))
            TwoLeggedAnimalComposable()

            Row(modifier = modifier.fillMaxWidth().padding(top = 10.dp), horizontalArrangement = Arrangement.End) {
                NextButton() {

                }
            }

        }

    }

    @Composable
    fun NextButton(modifier: Modifier = Modifier, onClick:()-> Unit){
        androidx.compose.material3.Button(
            onClick = onClick,
            modifier = modifier
                .fillMaxWidth(.4f)
                .padding(horizontal = 10.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Text(text = "Next", color = Color.Black, modifier = Modifier.padding(10.dp))
        }
    }

    @Composable
    fun Top(modifier: Modifier = Modifier){
        Spacer(modifier = modifier.height(60.dp))
        TitleScreen()
    }

    @Composable
    fun FourLeggedAnimalComposable(modifier: Modifier = Modifier){
        Column(modifier.fillMaxWidth()) {
            Text(text = "Four Legged Animals", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
            LazyVerticalGrid( contentPadding = PaddingValues(10.dp),columns = GridCells.Fixed(2)){
                items(fourLeggedAnimalData){
                    AnimalCards(image = it.first, animalName = it.second)
                }
            }
        }
    }

    @Composable
    fun TwoLeggedAnimalComposable(modifier: Modifier = Modifier){
        Column(modifier.fillMaxWidth()) {
            Text(text = "Two Legged Animals", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
            LazyVerticalGrid( contentPadding = PaddingValues(10.dp),columns = GridCells.Fixed(2)){
                items(threeLeggedAnimalData){
                    AnimalCards(image = it.first, animalName = it.second)
                }
            }
        }
    }


    @Composable
    fun TitleScreen(){
       Text(text = "Select the animals you have on your farm", textAlign = TextAlign.Center, fontSize = 18.sp, color = Color.Black)
    }


    @Composable
    fun AnimalCards(modifier: Modifier = Modifier, image: Int, animalName: String){
        Card(
            modifier
                .width(150.dp)
                .padding(top = 20.dp)
                .padding(end = 10.dp)
                .height(60.dp)) {
            Row(modifier.fillMaxSize()) {
                Image(painter = painterResource(id = image), contentDescription = "Picture of a $animalName",
                    contentScale = ContentScale.FillBounds, modifier = modifier
                        .fillMaxWidth(.4f)
                        .fillMaxHeight())
                Row(modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(), verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Text(text = animalName, modifier = modifier.padding(0.dp), color = Color.Black)
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Preview(){
        AppTheme {
            AnimalSelectScreenCompactScreen()
        }
    }
}