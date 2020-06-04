package cn.edu.scujcc.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button rankinglist_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rankinglist_button = (Button) findViewById(R.id.rankinglist_button);
        rankinglist_button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RankingList.class);
            startActivity(intent);
        });
        }
    }

