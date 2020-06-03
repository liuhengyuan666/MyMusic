package cn.edu.scujcc.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        int  REQUEST_EXTERNAL_STORAGE = 1;
        String[] PERMISSIONS_STORAGE ={
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

    }

    private void initView() {
    }
}
