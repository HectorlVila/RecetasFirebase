package hector.lagunas.recetasfirebase.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import hector.lagunas.recetasfirebase.R;
import hector.lagunas.recetasfirebase.adapters.ComidasAdapter;
import hector.lagunas.recetasfirebase.conexiones.ApiConexiones;
import hector.lagunas.recetasfirebase.conexiones.RetrofitObject;
import hector.lagunas.recetasfirebase.databinding.ActivityComidasBinding;
import hector.lagunas.recetasfirebase.helpers.Constantes;
import hector.lagunas.recetasfirebase.modelos.Comida;
import hector.lagunas.recetasfirebase.modelos.Comidas;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ComidasActivity extends AppCompatActivity {

    private ActivityComidasBinding binding;
    private ArrayList<Comida> listaComidas;
    private ComidasAdapter adapter;
    private RecyclerView.LayoutManager lm;
    private Retrofit retrofit;
    private ApiConexiones api;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityComidasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listaComidas = new ArrayList<>();
        adapter = new ComidasAdapter(this, R.layout.row_view_holder, listaComidas);
        lm = new LinearLayoutManager(this);

        binding.contentComidas.setAdapter(adapter);
        binding.contentComidas.setLayoutManager(lm);

        retrofit = RetrofitObject.getConexion();
        api = retrofit.create(ApiConexiones.class);

        String categoria = getIntent().getExtras().getString(Constantes.CATEGORIA);
        if (categoria != null){
            cargarComidas(categoria);
        }
    }

    private void cargarComidas(String categoria) {
        Call<Comidas> getComidas = api.getComidas(categoria);

        getComidas.enqueue(new Callback<Comidas>() {
            @Override
            public void onResponse(Call<Comidas> call, Response<Comidas> response) {
                if(response.code() == HttpsURLConnection.HTTP_OK){
                    listaComidas.addAll(response.body().getMeals());
                    adapter.notifyItemRangeChanged(0, listaComidas.size());
                }
            }

            @Override
            public void onFailure(Call<Comidas> call, Throwable t) {
                Toast.makeText(ComidasActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }
}