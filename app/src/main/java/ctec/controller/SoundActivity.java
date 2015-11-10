package ctec.controller;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.app.Activity;
import android.media.MediaPlayer;
import android.content.Intent;

public class SoundActivity extends Activity implements Runnable
{
    private Button startButton;
    private Button stopButton;
    private Button pauseButton;
    private Button videoButton;
    private MediaPlayer soundPlayer;
    private SeekBar soundSeekBar;
    private Thread soundThread;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);

        startButton = (Button) findViewById(R.id.startButton);
        pauseButton = (Button) findViewById(R.id.pauseButton);
        stopButton = (Button) findViewById(R.id.stopButton);
        soundSeekBar = (SeekBar) findViewById(R.id.soundSeekBar);
        videoButton = (Button) findViewById(R.id.videoButton);
        soundPlayer = MediaPlayer.create(this.getBaseContext(),R.raw.melancholy_hill);

        setupListeners();

        soundThread = new Thread(this);
        soundThread.start();
    }

    private void setupListeners()
    {
        startButton.setOnClickListener(new View.OnClickListener()
        {
           @Override
            public void onClick(View v)
           {
               soundPlayer.start();
           }
        });
    }

    pauseButton.setOnClickListener(new View.OnClickListener()
    {
       @Override
       public void onClick(View v)
        {
            soundPlayer.pause();
        }
    });
}
