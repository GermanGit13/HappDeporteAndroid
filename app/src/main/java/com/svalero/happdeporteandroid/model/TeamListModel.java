package com.svalero.happdeporteandroid.model;

import android.content.Context;
import android.util.Log;

import com.svalero.happdeporteandroid.api.HappDeporteApi;
import com.svalero.happdeporteandroid.api.HappDeporteApiInterface;
import com.svalero.happdeporteandroid.contract.TeamListContract;
import com.svalero.happdeporteandroid.domain.Team;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *Implementamos el contract TeamListContract.Model
 */
public class TeamListModel implements TeamListContract.Model {

    private Context context; //para poder pasarle el contexto de la aplicacion

    public TeamListModel(Context context) {
        this.context = context;
    }

    /**
     * Sustituimos la llamada a la BBDD por la llamada a la API
     */
    @Override
    public void loadAllTeams(OnLoadTeamsListener listener) {
        //Nos devuelve una instancia de happDeporteApi como la definimos en TodoApiInterface, tiene los métodos que usamos para comunicarnos con la API
        HappDeporteApiInterface happDeporteApi = HappDeporteApi.buildInstance();
        Call<List<Team>> callTeams = happDeporteApi.getTeams(); //Para realizar la llamada y user el getTeams definido
        Log.d("teams", "Llamada desde el model"); //Para depurar errores y ver si avanza o donde se para
        callTeams.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                Log.d("teams", "Llamada desde el model Ok"); //linea para depurar y ver que pasa
                List<Team> teams = response.body(); //Metemos la respuesta en una lista
                listener.onLoadTasksSuccess(teams); //recibimos la lista por el listener
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {
                Log.d("teams", "Llamada desde model error"); //linea para depurar y ver que pasa
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onLoadTasksError(message); //recibimos los mensajes de error por listener
            }
        });
    }
}
