package samples.tech.com.sampleproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import im.ene.toro.widget.Container;

public class MainActivity extends AppCompatActivity {
    Container container;
    SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = findViewById(R.id.player_container);
        adapter = new SimpleAdapter();
        container.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        container.setAdapter(adapter);

    }
}
