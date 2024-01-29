package hector.lagunas.recetasfirebase.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import hector.lagunas.recetasfirebase.R;
import hector.lagunas.recetasfirebase.adapters.CategoriasAdapter;
import hector.lagunas.recetasfirebase.conexiones.ApiConexiones;
import hector.lagunas.recetasfirebase.conexiones.RetrofitObject;
import hector.lagunas.recetasfirebase.databinding.ActivityMainBinding;
import hector.lagunas.recetasfirebase.modelos.Categoria;
import hector.lagunas.recetasfirebase.modelos.Categorias;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<Categoria> listaCategorias;
    private CategoriasAdapter adapter;
    private RecyclerView.LayoutManager lm;
    private Retrofit retrofit;
    private ApiConexiones api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listaCategorias = new ArrayList<>();
        adapter = new CategoriasAdapter(this, R.layout.row_view_holder, listaCategorias);
        lm = new LinearLayoutManager(this);

        binding.contentCategorias.setAdapter(adapter);
        binding.contentCategorias.setLayoutManager(lm);
        retrofit = RetrofitObject.getConexion();
        api = retrofit.create(ApiConexiones.class);


        cargarCategorias();

    }

    private void cargarCategorias() {
        Call<Categorias> getCategorias = api.getCategorias();

        getCategorias.enqueue(new Callback<Categorias>() {
            @Override
            public void onResponse(Call<Categorias> call, Response<Categorias> response) {
                if (response.code() == HttpsURLConnection.HTTP_OK){
                    ArrayList<Categoria> temp = (ArrayList<Categoria>) response.body().getCategories();
                    listaCategorias.addAll(temp);
                    adapter.notifyItemRangeChanged(0, temp.size());
                }
            }

            @Override
            public void onFailure(Call<Categorias> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }
}