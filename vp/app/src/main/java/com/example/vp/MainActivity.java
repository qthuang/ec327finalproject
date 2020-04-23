package com.example.vp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //这里加入文本和display

    private Button feed;
    private Button edit_values;
    private Button pet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        feed = (Button) findViewById(R.id.feed);
        edit_values = (Button) findViewById(R.id.edit);
        pet = (Button) findViewById(R.id.pet);//等接上前端看看

        feed.setOnClickListener(this);
        edit_values.setOnClickListener(this);
        //这个pet怎么办啊
    }

    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.edit:{
                launchEditActivity();//needs implementation
                break;
            }
            case R.id.feed:{
                launchFeedActivity();//needs implementation
                break;
            }
            case R.id.pet:{
                //这里怎么办？
                break;
            }
        }
    }

    private void launchEditActivity()
    {
        Intent EditActivity = new Intent(MainActivity.this, EditValues.class);
        startActivity(EditActivity);
    }

    private void launchFeedActivity()
    {
        Intent FeedActivity = new Intent(MainActivity.this, Feed.class);
        startActivity(FeedActivity);
    }


}
