package com.etcmobileapps.dovizkurlari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView dovizListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final CustomListAdapter listViewAdapter[] = new CustomListAdapter[1];
        dovizListView = (ListView) findViewById(R.id.dovizListView);

        ArrayList<Repo> dovizListesi = new ArrayList<>();
        final Interface[] restInterface = new Interface[1];
        restInterface[0] = ApiClient.getClient("https://api.orhanaydogdu.com.tr/").create(Interface.class);

        Call<Repo> call =restInterface[0].dovizListele();
        call.enqueue(new Callback<Repo>() {
            @Override
            public void onResponse(Call<Repo> call, Response<Repo> response) {

                if (response.body() != null) {


                    dovizListesi.add(response.body());



                }


                if (dovizListesi.size() > 0) {
                    listViewAdapter[0] = new CustomListAdapter(MainActivity.this, dovizListesi);
                    dovizListView.setAdapter(listViewAdapter[0]);


                }





            }

            @Override
            public void onFailure(Call<Repo> call, Throwable t) {

            }


        });





        dovizListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                view.findViewById(R.id.trLayout);
                View dolar =  view.findViewById(R.id.trLayout);
                View euro =  view.findViewById(R.id.euroLayout);
                View yen =  view.findViewById(R.id.yenLayout);
                View sterlin =  view.findViewById(R.id.sterlinLayout);
                View frang =  view.findViewById(R.id.frangLayout);
                View kanada =  view.findViewById(R.id.kanadaLayout);
                View avusturalya =  view.findViewById(R.id.audLayout);


                dolar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(MainActivity.this, "Dolara tıklandı.", Toast.LENGTH_SHORT).show();
                    }
                });
                euro.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(MainActivity.this, "Euro tıklandı.", Toast.LENGTH_SHORT).show();
                    }
                });

                yen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(MainActivity.this, "Yen tıklandı.", Toast.LENGTH_SHORT).show();
                    }
                });
                sterlin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(MainActivity.this, "Sterlin tıklandı.", Toast.LENGTH_SHORT).show();
                    }
                });
                frang.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(MainActivity.this, "Frang tıklandı.", Toast.LENGTH_SHORT).show();
                    }
                });
                kanada.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(MainActivity.this, "Kanada tıklandı.", Toast.LENGTH_SHORT).show();
                    }
                });
                avusturalya.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(MainActivity.this, "Avusturalya tıklandı.", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });






    }
}
