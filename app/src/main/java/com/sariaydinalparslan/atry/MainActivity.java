package com.sariaydinalparslan.atry;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import org.jitsi.meet.sdk.BroadcastEvent;
import org.jitsi.meet.sdk.BroadcastIntentHelper;
import org.jitsi.meet.sdk.JitsiMeet;
import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

import timber.log.Timber;



public class MainActivity extends AppCompatActivity {
    EditText cText ;
    Button button4 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cText = findViewById(R.id.cText);
        button4 = findViewById(R.id.button4);

        URL serverURl;

        try {
            serverURl = new URL("https://meet.jit.si");
            JitsiMeetConferenceOptions defaultOptions = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(serverURl)
                    .setAudioOnly(true)
                    .setVideoMuted(false)
                    .build();
            JitsiMeet.setDefaultConferenceOptions(defaultOptions);
        }catch (MalformedURLException e ){
            e.printStackTrace();
        }

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JitsiMeetConferenceOptions roomOptions = new JitsiMeetConferenceOptions.Builder()
                        .setRoom(cText.getText().toString())
                        .build();
                JitsiMeetActivity.launch(MainActivity.this,roomOptions);
            }
        });
    }
}