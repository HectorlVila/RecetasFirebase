package hector.lagunas.recetasfirebase.conexiones;

import hector.lagunas.recetasfirebase.modelos.Categorias;
import hector.lagunas.recetasfirebase.modelos.Comidas;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiConexiones {
    @GET("/api/json/v1/1/categories.php")
    Call<Categorias> getCategorias();

    @GET("/api/json/v1/1/filter.php")
    Call<Comidas> getComidas(@Query("c") String categoria);

    @GET("/api/json/v1/1/lookup.php")
    Call<Comidas> getRecetas(@Query("i") String id);
}
