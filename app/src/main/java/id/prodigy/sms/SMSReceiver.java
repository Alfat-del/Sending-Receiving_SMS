package id.prodigy.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

public class SMSReceiver extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onReceive(Context context, Intent intent) {
        // ----> Get he SMS message passed in
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs = null;
        String str = "SMS from ";
        if (bundle != null) {
            // ----> Retrieve the SMS message received
            msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent);

            for(int i = 0; i < msgs.length; i++) {
                str += msgs[i].getMessageBody().toString();
            }
            // ----> Display the new SMS message
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
            Log.d("SMSReceiver", str);


        }
    }
}

