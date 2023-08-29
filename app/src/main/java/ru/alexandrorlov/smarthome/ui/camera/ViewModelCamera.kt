package ru.alexandrorlov.smarthome.ui.camera

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexandrorlov.smarthome.R
import ru.alexandrorlov.smarthome.base.BaseViewModel
import ru.alexandrorlov.smarthome.ui.camera.state.StateCamera
import ru.alexandrorlov.smarthome.ui.camera.state.StateCameraAction
import ru.alexandrorlov.smarthome.ui.camera.state.StateCameraUi
import ru.alexandrorlov.smarthome.usecase.FetchOrGetCamerasUseCase
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class ViewModelCamera @Inject constructor(
    private val useCase: FetchOrGetCamerasUseCase
) :
    BaseViewModel<StateCameraUi, StateCameraAction>(StateCameraUi(StateCamera.Loading)) {

    private val _uiState = MutableStateFlow(StateCameraUi())
    val uiState = _uiState.asStateFlow()

    init {
        fetchData()
    }

    override fun onAction(actions: StateCameraAction) {
        TODO("Not yet implemented")
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                useCase.execute().collect { list ->
                    if (list.isNotEmpty()) {
                        _uiState.update {
                            it.copy(
                                stateCamera = StateCamera.Data(list)
                            )
                        }
                    } else {
                        _uiState.update {
                            it.copy(
                                stateCamera = StateCamera.Error(idMessage = R.string.exception_Exception)
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
            it.copy(stateCamera = StateCamera.Error(idMessage = idMessage))
        }
    }
}