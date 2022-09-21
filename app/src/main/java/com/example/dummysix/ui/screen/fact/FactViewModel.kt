package com.example.dummysix.ui.screen.fact

import androidx.lifecycle.ViewModel
import com.example.dummysix.common.network.Error
import androidx.lifecycle.viewModelScope
import com.example.dummysix.R
import com.example.dummysix.common.network.fold
import com.example.dummysix.common.network.toError
import com.example.dummysix.common.network.validateHttpCodeErrorCode
import com.example.dummysix.di.IoDispatcher
import com.example.dummysix.domain.usecase.FactUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FactViewModel @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val factUseCase: FactUseCase
):ViewModel(){

    private val _factState: MutableStateFlow<FactState> = MutableStateFlow(FactState())
    val factState: StateFlow<FactState>
        get() = _factState.asStateFlow()

    fun getFacts(){
        _factState.update { it.copy(isLoading = true, error = null) }
        viewModelScope.launch(ioDispatcher){
            factUseCase.getFacts()
                .fold(
                    onSuccess = { fact ->
                        _factState.update {
                            it.copy(
                                status = Status.SUCCESS,
                                isLoading = false,
                                error = null,
                                fact = fact.toPresentation()
                            )
                        }
                    },
                    onError = { errorCode,_ ->
                        val error = handleError(errorCode.validateHttpCodeErrorCode())
                        _factState.update {
                            it.copy(
                                status = Status.ERROR,
                                isLoading = false,
                                error = error,
                                fact = null
                            )
                        }
                    },
                    onException = { exception ->
                        val error = handleError(exception.toError())
                        _factState.update {
                            it.copy(
                                status = Status.EXCEPTION,
                                isLoading = false,
                                error = error,
                                fact = null
                            )
                        }
                    }
                )
        }
    }
    private fun handleError(error: Error): FactError {
        return when (error) {
            Error.Connectivity -> FactError(
                errorMessage = R.string.connectivity_error,
                displayTryAgainBtn = true
            )
            is Error.HttpException -> FactError(
                errorMessage = error.messageResId,
                displayTryAgainBtn = true
            )
            is Error.Unknown -> FactError(
                errorMessage = R.string.connectivity_error,
                displayTryAgainBtn = false
            )
        }
    }
}