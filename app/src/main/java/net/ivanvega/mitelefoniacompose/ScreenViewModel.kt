package net.ivanvega.mitelefoniacompose

import android.telephony.SmsManager
import androidx.lifecycle.ViewModel

class ScreenViewModel: ViewModel() {

    fun sendSMS(){
        val smsManage = SmsManager.getDefault()
        smsManage.sendTextMessage("4451130103",
            null,
            "saludo",null,null
            )

    }

}