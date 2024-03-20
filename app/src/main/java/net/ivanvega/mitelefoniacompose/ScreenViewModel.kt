package net.ivanvega.mitelefoniacompose

import android.content.Context
import android.telephony.SmsManager
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel

class ScreenViewModel : ViewModel() {
    private val _phoneNumber = mutableStateOf(TextFieldValue())
    private val _message = mutableStateOf(TextFieldValue())

    val phoneNumber: State<TextFieldValue> = _phoneNumber
    val message: State<TextFieldValue> = _message

    fun setPhoneNumber(text: String) {
        _phoneNumber.value = TextFieldValue(text)
    }

    fun setMessage(text: String) {
        _message.value = TextFieldValue(text)
    }


    var stadoMensaje by  mutableStateOf(Mensajes())

    fun onvalue(valor:String, texto:String ){
        when(texto){
            "mensaje"->stadoMensaje=stadoMensaje.copy(mensjae = valor)
            "telefono"->stadoMensaje=stadoMensaje.copy(telefono = valor)
        }
    }




    fun sendSMS(context: Context, phoneNumber: String, message: String) {
        SmsManager.getDefault().sendTextMessage(phoneNumber, null, message, null, null)
    }
}

data class Mensajes(
    val mensjae:String="",
    val telefono:String=""
)