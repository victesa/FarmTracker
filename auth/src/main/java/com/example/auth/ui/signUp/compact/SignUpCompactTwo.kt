package com.example.auth.ui.signUp.compact

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
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

class SignUpCompactTwo {
    
    @Composable
    fun SignUpCompactTwoScreen(modifier: Modifier = Modifier){
        var email by remember {
            mutableStateOf("")
        }
        
        var password by remember {
            mutableStateOf("")
        }

        var isClickable = false

        if(email.isEmpty() || password.isEmpty()){
            isClickable = true
        }


        Column(
            modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)) {
            Top()
            Middle(isClickable = isClickable, email = email, emailOnValueChange = {email = it},
                password = password, passwordOnValueChange = {password = it})
            Bottom()
        }
    }

    @Composable
    fun Top(modifier: Modifier = Modifier){
        Column(
            modifier
                .fillMaxWidth()
                .fillMaxHeight(.3f),
            verticalArrangement = Arrangement.Center) {
            Spacer(modifier = modifier.height(40.dp))
            Logo()
        }
    }

    @Composable
    fun Middle(isClickable: Boolean, modifier: Modifier = Modifier,
               email: String, emailOnValueChange:(String)->Unit,
               password: String, passwordOnValueChange:(String)->Unit){
        Column(
            modifier
                .fillMaxWidth()
                .fillMaxHeight(.5f), horizontalAlignment = Alignment.End) {
            //Email Address TextField
            EditTextFields(label = "Email Address", 
                keyboardType = KeyboardType.Text, 
                value = email, onValueChange = emailOnValueChange)
            
            Spacer(modifier = modifier.height(20.dp))
            
            //Password TextField
            EditPasswordTextFields(label = "Password",
                value = password, onValueChange = passwordOnValueChange)

            
            Spacer(modifier = modifier.height(20.dp))
            
            //SignUp Button
            SignUpButton(isClickable = isClickable)
        }
    }
    
    @Composable
    fun Bottom(modifier: Modifier = Modifier){
        Column(
            modifier
                .fillMaxWidth()
                .fillMaxHeight(.9f), verticalArrangement = Arrangement.Top) {

            DividerText()
            Spacer(modifier = modifier.height(30.dp))

            Button(onClick = {}, modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.padding(10.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_icon_google),
                        contentDescription = null, // Provide a meaningful description if needed
                        modifier = Modifier.size(24.dp) // Adjust the size as per your requirements
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // Add spacing between image and text
                    Text(text = "Sign up with Google")
                }
            }
        }
    }
    
    @Composable
    fun DividerText(modifier: Modifier = Modifier){
        Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                Divider()
                Text(text = "Or Continue with",
                    modifier
                        .background(MaterialTheme.colorScheme.background)
                        .padding(10.dp))
            }
        }
    }

    @Composable
    fun SignUpButton(isClickable: Boolean, modifier: Modifier = Modifier){
        Button(onClick = { /*TODO*/ },
            enabled = isClickable,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primaryContainer)) {
            Text(text = "Sign Up", color = Color.Black, modifier = Modifier.padding(10.dp))
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
    fun EditTextFields(label: String, keyboardType: KeyboardType,
                       value: String, onValueChange:(String)-> Unit,
                       modifier: Modifier = Modifier){
        OutlinedTextField(modifier = modifier.fillMaxWidth(),value = value, onValueChange = onValueChange, label = { Text(text = label)},
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            shape = RoundedCornerShape(10.dp)
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun EditPasswordTextFields(label: String,
                               value: String,onValueChange:(String)-> Unit,
                               modifier: Modifier = Modifier){
        OutlinedTextField(modifier = modifier.fillMaxWidth(),value = value, onValueChange = onValueChange, label = { Text(text = label)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            shape = RoundedCornerShape(10.dp)
        )
    }

    @Preview
    @Composable
    fun Preview(){
        AppTheme {
            SignUpCompactTwoScreen()
        }
    }
}