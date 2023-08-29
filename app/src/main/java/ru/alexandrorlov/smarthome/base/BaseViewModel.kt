package ru.alexandrorlov.smarthome.base

import androidx.lifecycle.ViewModel
import androidx.navigation.NamedNavArgument
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

interface UiState
interface UiAction
interface UiNavCommand {
    val arguments: List<NamedNavArgument>
    val destination: String
}

abstract class BaseNavCommand : UiNavCommand {
    override val arguments: List<NamedNavArgument> = listOf()
}

abstract class BaseViewModel<State, Action>(initialState: State) :
    ViewModel()
        where State : UiState, Action : UiAction {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State>
        get() = _state.asStateFlow()


    abstract fun onAction(actions: Action)

    protected fun setState(state: State) {
        _state.value = state
    }

}