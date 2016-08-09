package com.example.user.helloworld4;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        if (message.length()>0) {
            String s = message.toLowerCase().replaceAll("\\W", "");

            Log.i("palindrom", s);
            isPalindrome(s);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }

    public void isPalindrome(String s){
        int length = s.length();
        int i, begin, end, middle;
        begin = 0;
        end = length-1;
        middle = (begin + end) / 2;
        for (i=begin; i<= middle; i++){
            if (s.charAt(begin)==s.charAt(end)){
                begin++;
                end--;
            }
            else{
                break;
            }
        }
        String dialog="";
        if (i==middle+1){
            dialog += "isPalindrom";
        }else{
            dialog+="not palindrom";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(dialog);
        AlertDialog dialog1 = builder.create();
        dialog1.show();
    }
}
