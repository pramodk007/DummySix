package com.example.dummysix.ui.screen.fact

import android.support.annotation.StringRes
import com.example.dummysix.domain.model.FactModel

data class FactState(
    val status: Status? = null,
    val isLoading: Boolean = false,
    val error: FactError? = null,
    val fact: FactModel? = null,
)
data class FactError(
    val displayTryAgainBtn: Boolean = false,
    @StringRes val errorMessage: Int? = null,
)
enum class Status {
    SUCCESS, ERROR, EXCEPTION
}