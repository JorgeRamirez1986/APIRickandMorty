package com.cb.rickmortyjorgealberto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    ItemAdapter itemAdapter;
    EditText pagina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        pagina = (EditText) findViewById(R.id.pagina);



        cargarInformacion(1);
    }


    public void cargarInformacion(Integer pagina){
        RetrofitClient.getInstance()
                .getApi()
                .getCharacters(pagina)
                .enqueue(new Callback<Character>() {
                    @Override
                    public void onResponse(Call<Character> call, Response<Character> response) {
                       if(response.body().getResults()!= null){
                           ArrayList<Result> results  = (ArrayList<Result>) response.body().getResults();


                           itemAdapter = new ItemAdapter(getApplicationContext(), results);
                           RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                           recyclerView.setLayoutManager(layoutManager);
                           recyclerView.setAdapter(itemAdapter);
                           itemAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onFailure(Call<Character> call, Throwable t) {
                        //handling failure
                    }
                });
    }


    public void buscar(View v){
        if(pagina.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"ingrese una página", Toast.LENGTH_LONG).show();
        }else{
            int numPagina = Integer.parseInt(pagina.getText().toString());
            cargarInformacion(numPagina);
        }
    }
}