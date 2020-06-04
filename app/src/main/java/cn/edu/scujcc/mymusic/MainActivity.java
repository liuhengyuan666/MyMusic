package cn.edu.scujcc.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView=findViewById(R.id.gridview);
        gridView.setAdapter();
    }
}
