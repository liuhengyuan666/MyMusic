package cn.edu.scujcc.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity {

    private ImageView backButton;
    private TextView musicName, singer;
    private ImageView musicPicture;
    private static SeekBar sb;
    private static TextView songCurrentDuration, songDuration;
    private ImageView pauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);



    }
}
