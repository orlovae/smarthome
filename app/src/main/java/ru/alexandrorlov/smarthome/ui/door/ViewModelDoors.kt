package ru.alexandrorlov.smarthome.ui.door

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexandrorlov.smarthome.R
import ru.alexandrorlov.smarthome.base.BaseViewModel
import ru.alexandrorlov.smarthome.ui.door.state.StateDoor
import ru.alexandrorlov.smarthome.ui.door.state.StateDoorUi
import ru.alexandrorlov.smarthome.usecase.FetchOrGetDoorsUseCase
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class ViewModelDoors @Inject constructor(
    private val useCase: FetchOrGetDoorsUseCase
) : BaseViewModel<StateDoorUi, StateDoorAction>(StateDoorUi(StateDoor.Loading)) {

    private val _uiState = MutableStateFlow(StateDoorUi())
    val uiState = _uiState.asStateFlow()

    init {
        fetchData()
    }

    override fun onAction(actions: StateDoorAction) {
        TODO("Not yet implemented")
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                useCase.execute().collect { list ->
                    if (list.isNotEmpty()) {
                        _uiState.update {
                            it.copy(
                                stateDoor = StateDoor.Data(list)
                            )
                        }
                    } else {
                        _uiState.update {
                            it.copy(
                                stateDoor = StateDoor.Error(idMessage = R.string.exception_Exception)
                            )
                        }
                    }
                }
            } catch (exception: Exception) {
                errorHandling(exception)
            }

        }

    }

    private fun errorHandling(exception: Exception) {
        val idMessage = when (exception) {
            is UnknownHostException ->
                R.string.exception_unknownHostException

            else ->
                R.string.exception_Exception
        }
        _uiState.update {
            it.copy(stateDoor = StateDoor.Error(idMessage = idMessage))
        }
    }
}