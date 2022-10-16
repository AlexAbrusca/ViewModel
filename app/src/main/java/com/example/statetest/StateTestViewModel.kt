package com.example.statetest

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class StateTestViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(StateTestUiState())
    val uiState: StateFlow<StateTestUiState> = _uiState.asStateFlow()

    private var counter by mutableStateOf(0)
    private var counterList = mutableStateListOf<Int>()


    fun updateCounter() {
        counter++
        counterList.add(counter)
    }
    fun reset(){
        counter = 0
        counterList.clear()
    }
    fun updateState(){
        _uiState.value = StateTestUiState(
            currentCounter = counter,
            counterSum = counterList.sum()
        )
    }
}



