package cn.edu.scujcc.mymusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView backButton;
    private TextView musicName, singer;
    private ImageView musicPicture;
    private static SeekBar sb;
    private static TextView songCurrentDuration, songDuration;
    private ImageView pauseButton;
    private ImageView previousButton,nextButton;

    //数据源
    List<LocalMusicBean>mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        initView();
        mDatas = new ArrayList<>();
        //加载本地数据源
        loadLocalMusicData();

    }

    private void loadLocalMusicData() {
        //加载本地存储当中的音乐mp3文件到集合当中
        //1.获取ContentResolver对象
    }

    private void initView() {
        //初始化控件的函数
        previousButton = findViewById(R.id.previous);
        pauseButton = findViewById(R.id.pause);
        nextButton = findViewById(R.id.next);
        singer = findViewById(R.id.singer);
        musicName = findViewById(R.id.music_name);

        previousButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.previous:

                break;
            case R.id.pause:

                break;
            case R.id.next:

                break;
        }
    }
}
