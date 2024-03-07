package com.dz.bmstu_trade.AddDevice

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WiFiPasswordInputViewModel : ViewModel() {
    private val ssid = "Proizvodstvo" // TODO: сдесь надо забирать ssid из model
    private val _state = MutableStateFlow(PasswordFieldState("", false, ssid))
    val state: StateFlow<PasswordFieldState> = _state

    fun onPasswordUpdated(newPassword: String) {
        this._state.value =  PasswordFieldState(
            password = newPassword,
            shown = _state.value.shown,
            ssid = ssid
        )
    }

    fun onShownUpdated() {
        this._state.value =  PasswordFieldState(
            password = _state.value.password,
            shown = !_state.value.shown,
            ssid = ssid
        )
    }
}

data class PasswordFieldState(
    val password: String,
    val shown: Boolean = false,
    val ssid: String,
)