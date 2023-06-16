package com.example.onboarding.ui.medium

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.onboarding.R


class OnBoardingMedium {
    @Composable
    fun OnBoardingScreen(navController: NavController, modifier: Modifier = Modifier) {
        Column(modifier.fillMaxSize().padding(horizontal = 6.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            CardView()
            ColumnAppTitle()
            Spacer(modifier = modifier.height(100.dp))
            StartButtons(navController)

        }

    }

    @Composable
    fun StartButtons(navController: NavController) {
        var color by remember {
            mutableStateOf(Color.Transparent)
        }
        Row(
            modifier = Modifier
                .border(2.dp, color = Color.White, RoundedCornerShape(10.dp))
                .background(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.secondaryContainer
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(onClick = {
                             navController.navigate("SignIn")
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.shadow(0.dp),
                elevation = ButtonDefaults.elevation(0.dp)
            ) {
                Text(
                    text = "Register",
                    Modifier.padding(15.dp),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            }

            TextButton(onClick = {
                navController.navigate("SignIn")
                color = Color.Gray
            }, modifier = Modifier) {
                Text(
                    text = "Login", modifier = Modifier
                        .padding(10.dp)
                        .padding(horizontal = 20.dp), fontSize = 25.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            }

        }
    }

    @Composable
    fun CardView(modifier: Modifier = Modifier) {

        androidx.compose.material.Card(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .padding(horizontal = 24.dp)
                .padding(vertical = 34.dp),
            elevation = 5.dp,
            shape = RoundedCornerShape(20.dp),
            backgroundColor = MaterialTheme.colorScheme.secondaryContainer
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_task_image_1),
                    contentDescription = "Image",
                    contentScale = ContentScale.Fit,
                    modifier = modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                )
            }
        }
    }

    @Composable
    fun StartText(text: String, color: Color, fontSize: Int, fontWeight: FontWeight) {
        Text(
            text = text, color = color, style = TextStyle(
                fontSize = fontSize.sp,
                fontWeight = fontWeight,
            )
        )
    }

    @Composable
    fun ColumnAppTitle() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.5f)
                .padding(vertical = 10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 30.dp), verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StartText(
                    text = "Discover your",
                    color = Color.Black,
                    fontSize = 35,
                    fontWeight = FontWeight.Bold
                )
                StartText(
                    text = "Pros and Cons here",
                    color = Color.Black,
                    fontSize = 35,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StartText(
                    text = "Supervise your work progress",
                    color = Color.Black,
                    fontSize = 25,
                    fontWeight = FontWeight.Normal
                )
                StartText(
                    text = "with the best software",
                    color = Color.Black,
                    fontSize = 25,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }

}