package com.gefufeng.rndemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gefufeng.rndemo.utils.SharedPreferenceUtil;

public class MainActivity extends AppCompatActivity {

    private EditText inputContent;
    private TextView skipRN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    private void init(){
        inputContent = (EditText) findViewById(R.id.input_content);
        String content = (String) SharedPreferenceUtil.get(getApplication(),"rn_url","");
        if (!TextUtils.isEmpty(content)){
            inputContent.setText(content);
        }
        skipRN = (TextView) findViewById(R.id.skip_rn);
        skipRN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(inputContent.getText().toString())){
                    Toast.makeText(getApplicationContext(),"请输入地址",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this,RNActivity.class);
                intent.putExtra("url",inputContent.getText().toString().trim());
                startActivity(intent);
                SharedPreferenceUtil.put(getApplication(),"rn_url",inputContent.getText().toString().trim());
            }
        });
    }
}
