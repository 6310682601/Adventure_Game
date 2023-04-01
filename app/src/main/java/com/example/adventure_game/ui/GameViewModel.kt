package com.example.adventure_game.ui

import androidx.lifecycle.ViewModel
import com.example.adventure_game.data.Storys
import com.example.adventure_game.data.dialogs
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class GameViewModel : ViewModel() {
    var index = 0

    private val _uiState = MutableStateFlow(GameUiState(
        currentStorys = dialogs[index],
        choice = dialogs[index].choice,
        index = 0
        ))

    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    fun getDialog(index: Int) {
        val currentStorys = dialogs[index]
        val choice = dialogs[index].choice
        val newState = GameUiState(currentStorys = dialogs[index], choice = dialogs[index].choice, index = index)
        _uiState.value = newState
    }

    fun check(choice: String) {
        if (index == 0) {
            if (choice == "0") {
                index = 1
                getDialog(index)
            } else {
                index = 2
                getDialog(index)
            }
        }else if(index == 2) {
            if (choice == "0") {
                index = 3
                getDialog(index)
            } else {
                index = 3
                getDialog(index)
            }
        }else if (index == 3) {
            if (choice == "0") {
                index = 4
                getDialog(index)
            } else {
                index = 5
                getDialog(index)
            }
        }else if (index == 4) {
            if (choice == "0") {
                index = 5
                getDialog(index)
            } else {
                index = 5
                getDialog(index)
            }
        }

    }
}