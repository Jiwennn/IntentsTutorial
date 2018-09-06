package com.example.jiwen.intentstutorial;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.textView2);
        textView.setText("Hi " + name + ", please enter a URL");

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBrowser(view);
            }
        });
    }

    public void openBrowser(View view){
        EditText editText = findViewById(R.id.editText);

        String url = editText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        startActivityForResult(intent,1);
        //finish();
        //onActivityResult(1,RESULT_OK,intent);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                TextView textView = findViewById(R.id.textView2);
                textView.setText("you have opened a browser");
                //EditText editText = findViewById(R.id.editText);
                //editText.setEnabled(false);
            }
        }
    }
}
