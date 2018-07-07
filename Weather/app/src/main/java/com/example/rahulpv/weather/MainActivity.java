package com.example.rahulpv.weather;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    TextView tx,cityView,tempView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String cityName="Kochi";
        cityView=findViewById(R.id.city);
        tempView=findViewById(R.id.temp);
        tx = findViewById(R.id.tex);

        Typeface weatherFace=Typeface.createFromAsset(getAssets(),"weather.ttf");
        if (tx != null)
            tx.setTypeface(weatherFace);
        execute(new String[]{cityName});

        }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
       switch(requestCode){
           case 20:
               if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                   GPSTracker gps = new GPSTracker(this);
                   if (gps.canGetLocation()) {
                       String lat = gps.getLatitude();
                       String lon = gps.getLongitude();
                       execute(new String[]{lat, lon});
                   }
                   else {
                        gps.showSettingsAlert();
                   }
               }
       }

    }

    public void execute(String[] args){
            JSONObject weather=null;
            WeatherTask task=new WeatherTask();
            try {
                if(args.length==1) {
                    weather = task.execute(args[0]).get();
                }
                else{
                    weather=task.execute(args).get();
                }
            }catch(InterruptedException iex){
                iex.printStackTrace();
            }catch(ExecutionException ex){
                ex.printStackTrace();
            }
            try {
                int id=weather.getJSONArray("weather").getJSONObject(0).getInt("id");
                String cityName=weather.getString("name");
                Double temp=weather.getJSONObject("main").getDouble("temp");
                cityView.setText(cityName);
                tempView.setText(temp.toString());
                String ic=Utils.setWeatherIcon(this,id);
                if (tx != null)
                    tx.setText(ic);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    public void run() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 20);
            } else {
                GPSTracker gps = new GPSTracker(this);
                if (gps.canGetLocation()) {
                    String lat = gps.getLatitude();
                    String lon = gps.getLongitude();
                    execute(new String[]{lat, lon});
                } else {
                    gps.showSettingsAlert();
                }
            }
        }
        else{
            GPSTracker gps = new GPSTracker(this);
            if (gps.canGetLocation()) {
                String lat = gps.getLatitude();
                String lon = gps.getLongitude();
                execute(new String[]{lat, lon});
            }
            else {
                gps.showSettingsAlert();
            }
        }
    }
    public void search(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        LayoutInflater inflater=getLayoutInflater();
        View dialgueView=inflater.inflate(R.layout.layout_search, null );
        builder.setView(dialgueView);
        final EditText citySearch=dialgueView.findViewById(R.id.citySearch);
        builder.setTitle("Search City");
        builder.setMessage("Enter the city name to search");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                String city=citySearch.getText().toString();
                execute(new String[]{city});
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alert=builder.create();
        alert.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_weather,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.gps){
            run();
        }
        if(id==R.id.search){
            search();
            }
        return super.onOptionsItemSelected(item);

    }
}

