package com.example.user.helloworld4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import controller.AppController;

public class ShowGridActivity extends AppCompatActivity {

    GridView gridView;
    static final String[] MOBILE_OS = new String[] {
            "Android", "iOS","Windows", "Blackberry" };
    public ArrayList<Guest> guests = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_grid);
        gridView = (GridView) findViewById(R.id.gridView1);
        String url = "http://dry-sierra-6832.herokuapp.com/api/people";
        JsonArrayRequest request = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.i("response","Response: "+response.toString() );
                        try {
                            for (int i=0;i<response.length();i++){

                                JSONObject obj = (JSONObject) response.get(i);
                                Guest g = new Guest();
                                g.setNama(obj.getString("name"));
                                g.setTanggal(obj.getString("birthdate"));
                                g.setImage(Integer.parseInt(obj.getString("id")));
                                Log.i("adapter","guest: " +String.valueOf(g));
                                guests.add(g);
                            }
                            Log.i("adapter","guests size inside method: " +String.valueOf(guests.size()));
                            gridView.setAdapter(new ImageAdapter(getApplicationContext(), guests));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.i("response","Error: " + error);
                    }
                });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(request);

        Log.i("adapter","guests size outside method: " +String.valueOf(guests.size()));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Guest g = guests.get(position);
                Intent intent = new Intent(getApplicationContext(), DisplayMessageActivity.class);
                intent.putExtra("BIRTHDAY",g.getTanggal());
                intent.putExtra("NAMA_GUEST",g.getNama());
                setResult(0, intent);
                finish();

            }
        });

    }
}
