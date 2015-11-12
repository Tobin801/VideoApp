package ctec.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.net.Uri;


public class VideoActivity extends Activity
{
    private VideoView myPlayer;
    private Button returnButton;
    private MediaController myVideoController;
    private Uri videoLocation;
    private Button debateButton;
    private Button derrickButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        myPlayer = (VideoView) findViewById(R.id.videoView);
        returnButton = (Button) findViewById(R.id.homeButton);
        debateButton = (Button) findViewById(R.id.debateButton);
        derrickButton = (Button) findViewById(R.id.derrickButton);

        videoLocation = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.derp_news_debate);
        myVideoController = new MediaController(this);
        //Prepare the video
        setupMedia();
        setupListeners();
    }

    private void setupMedia()
    {
        myPlayer.setMediaController(myVideoController);
        myPlayer.setVideoURI(videoLocation);
    }

    private void setupListeners()
    {
        debateButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View currentView)
            {
                videoLocation = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.derp_news_debate);
                setupMedia();
            }
        });

        derrickButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View currentView)
            {
                videoLocation = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.derrick);
                setupMedia();
            }
        });

       returnButton.setOnClickListener(new View.OnClickListener()
       {
           @Override
           public void onClick(View currentView)
           {
               Intent returnIntent = new Intent();
               setResult(RESULT_OK, returnIntent);
               finish();
           }
       });
    }
}
