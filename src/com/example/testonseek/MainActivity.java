package com.example.testonseek;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;

public class MainActivity extends Activity {

    private CustomVideoView player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPlayer();
    }

    private void initPlayer() {
        player = (CustomVideoView) findViewById(R.id.videoView1);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(player);
        player.setMediaController(mediaController);
        player.setVideoURI(Uri
                .parse("https://peepcode.com/system/uploads/2013/preview-peepcode-play-by-play-kytrinyx.mp4"));

        Intent second = new Intent(this, Second.class);
        startActivity(second);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        player.seekTo(15000);
        player.start();
    }
}
