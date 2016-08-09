package com.example.user.helloworld4;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView)findViewById(R.id.editText);
        textView.setTextSize(40);
        textView.setText(message);



    }

    public void showList(View view){
        Intent intent = new Intent(this, ShowListActivity.class);
        startActivityForResult(intent,0);
    }

    public void showGrid(View view){
        Intent intent = new Intent(this, ShowGridActivity.class);
        startActivityForResult(intent,1);
    }

    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode ==0) {
            final Button pilEventButton = (Button) findViewById(R.id.button_event);
            pilEventButton.setText(data.getStringExtra("NAMA_EVENT"));
        } else if (requestCode==1) {
            final Button pilGuestButton = (Button) findViewById(R.id.button_guest);
            pilGuestButton.setText(data.getStringExtra("NAMA_GUEST"));
            String birthday = data.getStringExtra("BIRTHDAY");
            if (birthday != null) {
                String[] parts = birthday.split("-");
                int tanggal = Integer.parseInt(parts[2]);
                String to = "";
                if (tanggal % 2 == 0 && tanggal % 3 == 0) {
                    to += "iOS";
                } else if (tanggal % 3 == 0) {
                    to += "android";
                } else if (tanggal % 2 == 0) {
                    to += "blackberry";
                } else {
                    to += "feature phone";
                }
                String isprime = isPrime(Integer.parseInt(parts[1]));
                Log.i("prima",isprime);
                AlertDialog.Builder builder = new AlertDialog.Builder(DisplayMessageActivity.this);
                builder.setMessage(isprime);
                AlertDialog dialog1 = builder.create();
                dialog1.show();
                Toast.makeText(
                        getApplicationContext(),
                        to, Toast.LENGTH_SHORT).show();
            }
        }
    }
    public String isPrime(int month){
        if (month==1){
            return "not prime";
        }
        for (int i=2;2*i<month;i++){
            if(month%i==0){
                return "not prime";
            }
        }
        return "isPrime";
    }
}
