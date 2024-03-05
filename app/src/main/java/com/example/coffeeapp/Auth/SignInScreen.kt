package com.google.firebase.quickstart.auth.kotlin

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.coffeeapp.R
import com.example.coffeeapp.ui.theme.CoffeeAppTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.example.coffeeapp.Auth.SignInViewModel
import com.example.coffeeapp.Model.User
import com.example.coffeeapp.ui.theme.gilroy
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


@Composable
fun SignInScreen(
    openAndPopUp: (String, String) -> Unit,
    viewModel: SignInViewModel = hiltViewModel(),
) {
    val context = LocalContext.current

    val email = viewModel.email.collectAsState()
    val password = viewModel.password.collectAsState()

    var showPassword by remember { mutableStateOf(value = false) }

    Box(
        modifier = Modifier
            .background(Color(0xFF201B18))
            .fillMaxSize()
    ) {
        Image(
            contentDescription = null,
            painter = painterResource(id = R.drawable.backgroundtransparent),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .absolutePadding(top = 40.dp)
                .absoluteOffset(y = 40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_coffee),
                contentDescription = null,
                modifier = Modifier.size(70.dp)
            )
            Text(
                text = "COFFEE TATES!",
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontFamily = gilroy,
                fontSize = 14.sp,
                letterSpacing = 8.sp
            )
            Spacer(modifier = Modifier.size(90.dp))
            Text(
                text = "Sign In",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = gilroy,
                fontSize = 40.sp
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "We’ve already met!",
                color = Color.White.copy(0.7f),
                fontWeight = FontWeight.Light,
                fontFamily = gilroy,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.size(75.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                OutlinedTextField(
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        unfocusedLeadingIconColor = Color.White

                    ),
                    singleLine = true,
                    value = email.value,
                    onValueChange = { viewModel.updatePhone(it) },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .width(330.dp)
                        .height(64.dp),
                    label = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("EMAIL", color = Color(0xFFFFFFFF), fontSize = 12.sp)
                            Text("*", color = Color.Red, fontSize = 12.sp)
                        }
                    },
                    leadingIcon = {
                        Icon(
                            contentDescription = null,
                            tint = Color.White,
                            imageVector = Icons.Rounded.Email,
                            modifier = Modifier.size(25.dp),
                        )
                    },
                )
                Spacer(modifier = Modifier.size(12.dp))
                OutlinedTextField(
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        unfocusedLabelColor = Color.White,
                        unfocusedLeadingIconColor = Color.White
                    ),
                    singleLine = true,
                    maxLines = 1,
                    visualTransformation = if (showPassword) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    },
                    value = password.value,
                    onValueChange = {
                        viewModel.updatePassword(it)
                    },
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .height(64.dp)
                        .width(330.dp),
                    label = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("PASSWORD", color = Color(0xFFFFFFFF), fontSize = 12.sp)
                            Text("*", color = Color.Red, fontSize = 12.sp)
                        }
                    },
                    leadingIcon = {
                        Icon(
                            contentDescription = null,
                            painter = painterResource(id = R.drawable.baseline_password_24),
                            tint = Color.White,
                            modifier = Modifier.size(25.dp)
                        )
                    },
                    trailingIcon = {
                        if (showPassword) {
                            IconButton(onClick = { showPassword = false }) {
                                Icon(
                                    contentDescription = null,
                                    painter = painterResource(id = R.drawable.baseline_visibility_24)
                                )
                            }
                        } else {
                            IconButton(onClick = { showPassword = true }) {
                                Icon(
                                    contentDescription = null,
                                    painter = painterResource(id = R.drawable.baseline_visibility_off_24)
                                )
                            }
                        }
                    },
                )
                Spacer(modifier = Modifier.size(12.dp))
                Text(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center,
                    text = "Forgot password?",
                    color = Color(0xFFA97C37),
                    fontSize = 16.sp,
                    textDecoration = TextDecoration.Underline,
                )
                Spacer(modifier = Modifier.size(70.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(Color(0xFF55433C)),
                    shape = RoundedCornerShape(9.dp),
                    onClick = {
                        viewModel.onSignInClick(openAndPopUp)
                        if (email.value.isEmpty() && password.value.isEmpty()) {
                            Toast.makeText(context, "Inválido", Toast.LENGTH_LONG).show()
                        } else {
                            FirebaseAuth.getInstance()
                                .signInWithEmailAndPassword(email.value, password.value)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        Toast.makeText(context, "Successful", Toast.LENGTH_LONG)
                                            .show()
                                    } else {
                                        Toast.makeText(context, "Wrong", Toast.LENGTH_LONG).show()

                                    }
                                }
                        }
                    },
                    modifier = Modifier
                        .width(320.dp)
                        .height(56.dp)
                ) {
                    Text(
                        "Sign In",
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .weight(1f)
                            .offset(x = 8.dp),
                        fontSize = 18.sp,
                        fontFamily = gilroy,
                        fontWeight = FontWeight.Bold
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = Color.White

                    )
                }
                Spacer(modifier = Modifier.padding(6.dp))
                Row()
                {
                    Text(
                        text = "Don’t have an account? ",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                    Text(
                        text = "Sign Up",
                        color = Color(0xFFA97C37),
                        textDecoration = TextDecoration.Underline,
                        fontSize = 15.sp
                    )
                }

            }
        }

    }
}


@Composable
fun PreviewSignIn() {
    CoffeeAppTheme {
        SignInScreen({ _, _ -> })

    }

}
