package com.example.auth.ui.signIn.large

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.auth.R

class SignInLarge {

    @Composable

    fun SignInLargeScreen(modifier: Modifier = Modifier){
        var email by remember {
            mutableStateOf("")
        }
        var password by remember {
            mutableStateOf("")
        }
        Row(modifier = modifier.fillMaxSize()) {
            LeftSide()
            RightSide(email = email, emailOnValueChange = {email = it},
                 password = password, passwordOnValueChange = {password = it})
        }
    }

    @Composable
    fun LeftSide(modifier: Modifier = Modifier){
        Column(
            modifier
                .fillMaxHeight()
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .fillMaxWidth(.47f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = R.drawable.ic_task_image_1),
                contentScale = ContentScale.FillWidth,
                contentDescription = null)
            Spacer(modifier = modifier.height(50.dp))
            Text(text = "FarmTracker", fontSize = 50.sp, fontWeight = FontWeight.SemiBold, color = Color.Black)
            Text(text = "Supervision made easier", fontSize = 30.sp)
        }
    }

    @Composable
    fun RightSide(modifier: Modifier = Modifier,
                   email:String, emailOnValueChange:(String)-> Unit,
                  password: String, passwordOnValueChange:(String)-> Unit){
        Column(modifier = modifier
            .padding(26.dp)
            .fillMaxWidth()
            .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally) {
            RightSideTop()
            RightSideMiddle(
                email = email,
                emailOnValueChange = emailOnValueChange,
                password = password,
                passwordOnValueChange = passwordOnValueChange
            )
            RightSideBottom()

        }
    }

    @Composable
    fun RightSideTop(modifier: Modifier = Modifier){
        Column(modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(.3f),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.ft1),
                modifier = modifier.fillMaxWidth(),
                contentDescription ="Logo" )
            Spacer(modifier = modifier.height(20.dp))
            Text(text = "Welcome back.", fontSize = 25.sp, color = Color.Black)
        }
    }

    @Composable
    fun RightSideMiddle(modifier: Modifier = Modifier, email:String, emailOnValueChange:(String)-> Unit,
                        password: String, passwordOnValueChange:(String)-> Unit){


        Column(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 60.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            //Email Address TextField
            EditTextFieldsLarge(label = "Email Address",
                keyboardType = KeyboardType.Text, value = email, onValueChange = emailOnValueChange)

            Spacer(modifier = modifier.height(40.dp))

            //Password TextField
            EditTextFieldsLarge(label = "Password",
                keyboardType = KeyboardType.Text, value = password, onValueChange = passwordOnValueChange)

            Spacer(modifier = modifier.height(70.dp))

            //Sign Up Button
            SignInButton()
        }
    }

    @Composable
    fun RightSideBottom(modifier: Modifier = Modifier){
        Column(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 60.dp), horizontalAlignment = Alignment.CenterHorizontally) {


            Spacer(modifier = modifier.height(30.dp))

            Text(text = "Or", fontSize = 20.sp)

            Spacer(modifier = modifier.height(30.dp))

            OutlinedButton(onClick = {}, colors = ButtonDefaults.buttonColors(Color.White),
                modifier = modifier
                    .fillMaxWidth(.7f)
                    .padding(horizontal = 10.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.padding(10.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_icon_google),
                        contentDescription = null, // Provide a meaningful description if needed
                        modifier = Modifier.size(24.dp) // Adjust the size as per your requirements
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // Add spacing between image and text
                    Text(text = "Sign in with Google", color = Color.Black)
                }
            }

            Row(modifier = modifier.fillMaxWidth().padding(top = 20.dp), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Text(text = "Create account", color = Color.Black, fontSize = 20.sp, modifier = modifier.padding(10.dp))

            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun EditTextFieldsLarge(label: String, keyboardType: KeyboardType,
                            value: String, onValueChange:(String)-> Unit,
                            modifier: Modifier = Modifier
    ){
        OutlinedTextField(modifier = modifier.fillMaxWidth(.7f),value = value, onValueChange = onValueChange, label = { Text(text = label) },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            shape = RoundedCornerShape(10.dp)
        )
    }

    @Composable
    fun SignInButton(modifier: Modifier = Modifier){
        Button(onClick = { /*TODO*/ },
            modifier = modifier
                .fillMaxWidth(.7f)
                .padding(horizontal = 10.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primaryContainer)) {
            Text(text = "Sign Up", color = Color.Black, modifier = Modifier.padding(10.dp))
        }
    }



    @Preview(showBackground = true, device = "spec:width=1920dp,height=1080dp,dpi=480")
    @Composable
    fun Preview(){

    }
}