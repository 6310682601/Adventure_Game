package com.example.adventure_game.ui

import com.example.adventure_game.data.Storys

data class GameUiState(
    val currentStorys: Storys,
    val choice: List<String>,
    val index: Int,
    val ending: Int
)