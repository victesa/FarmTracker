package com.example.summary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.summary.theme.AppTheme

class HomeScreenCompact {
    @Composable
    fun HomeScreenCompactScreen(modifier: Modifier = Modifier){

    }

    @Composable
    fun ProgressDialog(modifier: Modifier = Modifier){
        Box(contentAlignment = Alignment.Center) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.inversePrimary,
                progress = .6f,
                modifier = modifier
                    .size(74.dp),
                strokeWidth = 6.dp
            )
            Text(
                text = "64%",
                fontSize = 23.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

    }

    @Composable
    fun ProgressDialogRow(modifier: Modifier = Modifier){
        Row(modifier.fillMaxWidth()) {
            ProgressDialog()
            Spacer(modifier = modifier.width(25.dp))
            Column(modifier.fillMaxWidth()) {
                Text(text = "of your end", fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
                Text(text = "goal completed", fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
            }
        }
    }

    @Composable
    fun CardViewHistory(modifier: Modifier = Modifier){
        Card(modifier = modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            elevation = CardDefaults.cardElevation(0.dp)) {
            Column(
                modifier
                    .padding(10.dp)
                    .padding(horizontal = 10.dp)
                    .padding(top = 8.dp)) {
                Row(modifier = modifier
                    .fillMaxWidth()
                    , horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "History", fontWeight = FontWeight.SemiBold, color = Color.Black)
                    Text(text = "Last Month", color = MaterialTheme.colorScheme.onSecondaryContainer)
                }

                SummaryIndicator()

                Spacer(modifier = modifier.height(30.dp))

                Divider()

                Spacer(modifier = modifier.height(10.dp))

                DetailCard(painter = R.drawable.incoming_call)

                DetailCard(painter = R.drawable.outgoing_call)
            }
        }
    }

    @Composable
    fun DetailCard(painter: Int, modifier: Modifier = Modifier){
        Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Card(colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer), modifier = modifier.padding(6.dp)) {
                Icon(painter = painterResource(id = painter),
                    contentDescription = null, tint = Color.Red, modifier = modifier
                        .size(42.dp)
                        .padding(10.dp))
            }

            Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Column() {
                    Text(text = "Sean Kim", fontWeight = FontWeight.SemiBold, fontSize = 17.sp, color = Color.Black)
                    Text(text = "Expenses", fontSize = 13.sp, color = Color.Gray)
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(text = "-10,000shs", fontWeight = FontWeight.SemiBold, fontSize = 17.sp, color = Color.Black)
                    Text(text = "1/02/2023", fontSize = 13.sp, color = Color.Gray)
                }
            }
        }
    }

    @Composable
    fun SummaryIndicator(modifier: Modifier = Modifier){
        Column(modifier = modifier.fillMaxWidth()) {
            Spacer(modifier = modifier.height(15.dp))
            Text(text = "2,000 shs", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = modifier.height(10.dp))
            androidx.compose.material.LinearProgressIndicator(progress = .6f,
                color = MaterialTheme.colorScheme.inversePrimary, backgroundColor = MaterialTheme.colorScheme.error,
                modifier = modifier
                    .height(15.dp)
                    .fillMaxWidth(), strokeCap = StrokeCap.Round)

        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Preview(){
        AppTheme() {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp), verticalArrangement = Arrangement.Center) {
                CardViewHistory()
            }
        }
    }
}