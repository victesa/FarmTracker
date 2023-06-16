package com.example.auth.ui.signUp.compact

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.auth.R
import com.example.onboarding.ui.theme.AppTheme

class SignUpCompact {
    @Composable
    fun SignUpCompactScreen(modifier: Modifier = Modifier){
        var firstName by remember {
            mutableStateOf("")
        }
        var lastName by remember {
            mutableStateOf("")
        }
        var isClickable = false

        if(firstName.isNotEmpty()|| lastName.isNotEmpty()){
            isClickable = true
        }

        Column(
            modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Top()

            Middle(firstName = firstName,
                firstNameValueChange = {firstName = it},
                lastName = lastName,
                lastNameValueChange = {lastName = it})

            Bottom(isClickable = isClickable)




        }

    }

    @Composable
    fun Top(modifier: Modifier = Modifier){
        Column(
            modifier
                .fillMaxWidth()
                .fillMaxHeight(.3f),
            verticalArrangement = Arrangement.Center) {
            Spacer(modifier = modifier.height(20.dp))
            Logo()
        }
    }

    @Composable
    fun Middle(firstName:String, firstNameValueChange:(String)->Unit,
        lastName: String, lastNameValueChange:(String) -> Unit,
               modifier: Modifier = Modifier){
        Column(
            modifier
                .fillMaxWidth()
                .fillMaxHeight(.5f),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(20.dp))
            //First name TextField
            EditTextFields(label = "First Name",
                keyboardType = KeyboardType.Text,
                value = firstName, onValueChange = firstNameValueChange)

            Spacer(modifier = modifier.height(20.dp))

            //Last name TextField
            EditTextFields(label = "Last Name",
                keyboardType = KeyboardType.Text,
                value = lastName, onValueChange = lastNameValueChange)
        }
    }

    @Composable
    fun Bottom(modifier: Modifier = Modifier, isClickable: Boolean){
        Column(
            modifier
                .fillMaxWidth()
                .fillMaxHeight(.9f),
        verticalArrangement = Arrangement.Bottom) {
            Text(text = "By clicking Continue, you acknowledge that you " +
                    "have read the Privacy Policy and agree to the terms of " +
                    "Service." , lineHeight = 15.sp,
                fontSize = 12.sp, textAlign = TextAlign.Center)
            Spacer(modifier = modifier.height(10.dp))
            ContinueButton(isClickable = isClickable)
            Spacer(modifier = modifier.height(60.dp))
        }
    }

    @Composable
    fun Logo(modifier: Modifier = Modifier){
        Column(
            modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.ft1),
                contentDescription = "Image",
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Text(modifier = modifier
            .fillMaxWidth()
            .padding(top = 10.dp), text = "Supervise without limits",
            fontSize = 13.sp, textAlign = TextAlign.Center)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun EditTextFields(label: String,keyboardType: KeyboardType,
                       value: String,onValueChange:(String)-> Unit,
                       modifier: Modifier = Modifier){
        OutlinedTextField(modifier = modifier.fillMaxWidth(),value = value, onValueChange = onValueChange, label = { Text(text = label)},
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            shape = RoundedCornerShape(10.dp)
        )
    }


    @Composable
    fun ContinueButton(isClickable: Boolean, modifier: Modifier = Modifier){
        Button(onClick = { /*TODO*/ },
            enabled = isClickable,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primaryContainer)) {
            Text(text = "Continue", color = Color.Black, modifier = Modifier.padding(10.dp))
        }
    }

    @Preview(showBackground = true, device = "spec:width=411dp,height=891dp")
    @Composable
    fun Preview(){
        AppTheme() {
            SignUpCompactScreen()
        }
    }
}