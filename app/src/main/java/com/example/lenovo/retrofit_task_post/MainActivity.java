package com.example.lenovo.retrofit_task_post;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView lv_data,lv_in,lv_out;
    Button btn_all, btn_in, btn_out;

    MyAdapter myAdapter;

    ArrayList<DataProvider> arrayList =new ArrayList<>();
    ArrayList<DataProvider> in_arraylist=new ArrayList<>();
    ArrayList<DataProvider> out_arraylist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_data = (ListView) findViewById(R.id.lv_data_main);
        lv_in=(ListView)findViewById(R.id.lv_data1_main);
        lv_out=(ListView)findViewById(R.id.lv_data2_main);
        btn_all = (Button) findViewById(R.id.btn_all_main);
        btn_in = (Button) findViewById(R.id.btn_incoming_main);
        btn_out = (Button) findViewById(R.id.btn_out_main);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://giftzay.vmgtelecoms.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ApiResponse apiResponse = retrofit.create(ApiResponse.class);

            Call<Transactions> transactionsCall = apiResponse.request("25");

            transactionsCall.enqueue(new Callback<Transactions>() {
                @Override
                public void onResponse(Call<Transactions> call, Response<Transactions> response) {

                    Transactions transactions = response.body();

                    Log.e("data",transactions.toString());

                    List<IncomingList> incomingListList = transactions.getIncomingLists();

                    for (IncomingList incomingList:incomingListList){
                        String biller = incomingList.getBiller();
                        String amount = incomingList.getAmount();
                        String time = incomingList.getTime();

                        in_arraylist.add(new DataProvider(biller,amount,time));
                    }

                    List<OutgoingList> outgoingListList = transactions.getOutgoingLists();

                    for (OutgoingList outgoingList:outgoingListList){
                        String biller = outgoingList.getBiller();
                        String amount = outgoingList.getAmount();
                        String time = outgoingList.getTime();

                        out_arraylist.add(new DataProvider(biller,amount,time));
                    }

                    List<AlltransList> alltransListList = transactions.getAlltransLists();

                    for (AlltransList alltransList:alltransListList){
                        String biller = alltransList.getBiller();
                        String amount = alltransList.getAmount();
                        String time = alltransList.getTime();

                        arrayList.add(new DataProvider(biller,amount,time));
                    }
                }

                @Override
                public void onFailure(Call<Transactions> call, Throwable t) {

                }
            });

        myAdapter = new MyAdapter(MainActivity.this,arrayList);
        lv_data.setAdapter(myAdapter);

        lv_data.setVisibility(View.VISIBLE);

        btn_all.setBackgroundResource(R.drawable.btn_bg);
        btn_in.setBackgroundResource(R.drawable.btn_bg1);
        btn_out.setBackgroundResource(R.drawable.btn_bg1);


        btn_in.setTextColor(Color.parseColor("#13F571"));
        btn_out.setTextColor(Color.parseColor("#13F571"));
        btn_all.setTextColor(Color.parseColor("#ffffff"));


        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myAdapter = new MyAdapter(MainActivity.this,arrayList);
                lv_data.setAdapter(myAdapter);

                lv_data.setVisibility(View.VISIBLE);
                lv_in.setVisibility(View.GONE);
                lv_out.setVisibility(View.GONE);

                btn_all.setBackgroundResource(R.drawable.btn_bg);
                btn_in.setBackgroundResource(R.drawable.btn_bg1);
                btn_out.setBackgroundResource(R.drawable.btn_bg1);

                btn_all.isEnabled();

                btn_in.setTextColor(Color.parseColor("#13F571"));
                btn_out.setTextColor(Color.parseColor("#13F571"));
                btn_all.setTextColor(Color.parseColor("#ffffff"));

            }
        });

        btn_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter=new MyAdapter(MainActivity.this,in_arraylist);
                lv_in.setAdapter(myAdapter);

                lv_in.setVisibility(View.VISIBLE);
                lv_data.setVisibility(View.GONE);
                lv_out.setVisibility(View.GONE);

                btn_all.setBackgroundResource(R.drawable.btn_bg1);
                btn_in.setBackgroundResource(R.drawable.btn_bg);
                btn_out.setBackgroundResource(R.drawable.btn_bg1);

                btn_in.setTextColor(Color.parseColor("#ffffff"));
                btn_out.setTextColor(Color.parseColor("#13F571"));
                btn_all.setTextColor(Color.parseColor("#13F571"));

            }
        });
        btn_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myAdapter = new MyAdapter(MainActivity.this,out_arraylist);
                lv_out.setAdapter(myAdapter);

                lv_out.setVisibility(View.VISIBLE);
                lv_data.setVisibility(View.GONE);
                lv_in.setVisibility(View.GONE);
                btn_all.setBackgroundResource(R.drawable.btn_bg1);
                btn_in.setBackgroundResource(R.drawable.btn_bg1);
                btn_out.setBackgroundResource(R.drawable.btn_bg);

                btn_in.setTextColor(Color.parseColor("#13F571"));
                btn_out.setTextColor(Color.parseColor("#ffffff"));
                btn_all.setTextColor(Color.parseColor("#13F571"));

            }
        });
    }

}

