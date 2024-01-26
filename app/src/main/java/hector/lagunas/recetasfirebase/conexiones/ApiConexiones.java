package hector.lagunas.recetasfirebase.conexiones;

import hector.lagunas.recetasfirebase.modelos.Categorias;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiConexiones {
    @GET("/api/json/v1/1/categories.php")
    Call<Categorias> getCategorias();
}
