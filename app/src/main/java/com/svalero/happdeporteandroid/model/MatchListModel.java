package com.svalero.happdeporteandroid.model;

import android.content.Context;
import android.util.Log;

import com.svalero.happdeporteandroid.api.HappDeporteApi;
import com.svalero.happdeporteandroid.api.HappDeporteApiInterface;
import com.svalero.happdeporteandroid.contract.MatchListContract;
import com.svalero.happdeporteandroid.contract.UserListContract;
import com.svalero.happdeporteandroid.domain.Match;
import com.svalero.happdeporteandroid.domain.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *Implementamos el contract MatchListContract.Model
 */
public class MatchListModel implements MatchListContract.Model {

    private Context context; //para poder pasarle el contexto de la aplicacion

    //No lo usamos por que le pasamos el contexto desde el presenter para usar los mapas
//    public MatchListModel(Context context) {
//        this.context = context;
//    }

    /**
     * Sustituimos la llamada a la BBDD por la llamada a la API
     */
    @Override
    public void loadAllMatches(OnLoadMatchListener listener) {
        //Nos devuelve una instancia de happDeporteApi como la definimos en TodoApiInterface, tiene los métodos que usamos para comunicarnos con la API
        HappDeporteApiInterface happDeporteApi = HappDeporteApi.buildInstance();
        Call<List<Match>> callMatches = happDeporteApi.getMatches(); //Para realizar la llamada y usar el getMatches definido
        Log.d("matches", "Llamada desde el model"); //Para depurar errores y ver si avanza o donde se para
        callMatches.enqueue(new Callback<List<Match>>() {
            @Override
            public void onResponse(Call<List<Match>> call, Response<List<Match>> response) {
                Log.d("matches", "Llamada desde el model Ok"); //linea para depurar y ver que pasa
                List<Match> matches = response.body(); //Metemos la respuesta en una lista
                listener.onLoadTasksSuccess(matches); //recibimos la lista por el listener
            }

            @Override
            public void onFailure(Call<List<Match>> call, Throwable t) {
                Log.d("matches", "Llamada desde model error"); //linea para depurar y ver que pasa
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onLoadTasksError(message); //recibimos los mensajes de error por listener
            }
        });
    }
}
