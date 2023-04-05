package com.example.test

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel: ViewModel(){
    private val _state = MutableStateFlow(CounterUiState())
    val uiState: StateFlow<CounterUiState> = _state.asStateFlow()

    fun add(){
        _state.update {
            state -> state.copy(
            counterValue = state.counterValue+1
            )
        }
    }
}
