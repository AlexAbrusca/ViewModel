package com.example.statetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.statetest.ui.theme.StatetestTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StatetestTheme {
               Surface() {
                   AppStateTest()
               }
            }
        }
    }
}

@Composable
fun AppStateTest (
    modifier: Modifier = Modifier,
    stateTestViewModel: StateTestViewModel = viewModel()
){
   val stateTestUiState by stateTestViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
           modifier = Modifier
               .fillMaxWidth()
               .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Conteggio progressivo",
                fontSize = 20.sp
            )
            Text(
                text = "${stateTestUiState.currentCounter}",
                fontSize = 30.sp
            )
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = "Somma progressivo",
                fontSize = 20.sp
            )
            Text(
                text = "${stateTestUiState.counterSum}",
                fontSize = 30.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        ButtonType(text = "ADD") {
            stateTestViewModel.updateCounter()
            stateTestViewModel.updateState()
        }
        Spacer(modifier = Modifier.height(20.dp))
        ButtonType(text = "Reset") {
            stateTestViewModel.reset()
            stateTestViewModel.updateState()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StatetestTheme {
        AppStateTest()
    }
}