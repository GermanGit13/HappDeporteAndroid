package com.svalero.happdeporteandroid.api;

import static com.svalero.happdeporteandroid.api.Constants.BASE_URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Para la parte del código que se usa para instanciar el objeto que se comunicará con la API
 */
public class HappDeporteApi {

    /**
     * Método para instanstanciar la libreria retrofit y consumir la API
     *
     */
    public static HappDeporteApiInterface buildInstance() {
        Retrofit retrofit = new Retrofit.Builder() //creamos el objeto retrofit
                .baseUrl(BASE_URL) //URL BASE de la API
                .addConverterFactory(GsonConverterFactory.create()) //Para convertir los Gson
                .build();

        return retrofit.create(HappDeporteApiInterface.class); //devolvemos la libreria retrofit para usarla en la conexión
    }
}
