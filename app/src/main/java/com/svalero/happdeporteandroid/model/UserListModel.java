package com.svalero.happdeporteandroid.model;

import android.content.Context;
import android.util.Log;

import com.svalero.happdeporteandroid.api.HappDeporteApi;
import com.svalero.happdeporteandroid.api.HappDeporteApiInterface;
import com.svalero.happdeporteandroid.contract.TeamListContract;
import com.svalero.happdeporteandroid.contract.UserListContract;
import com.svalero.happdeporteandroid.domain.Team;
import com.svalero.happdeporteandroid.domain.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *Implementamos el contract UserListContract.Model
 */
public class UserListModel implements UserListContract.Model {

    private Context context; //para poder pasarle el contexto de la aplicacion

    public UserListModel(Context context) {
        this.context = context;
    }

    /**
     * Sustituimos la llamada a la BBDD por la llamada a la API
     */
    @Override
    public void loadAllUsers(OnLoadUserListener listener) {
        //Nos devuelve una instancia de happDeporteApi como la definimos en TodoApiInterface, tiene los métodos que usamos para comunicarnos con la API
        HappDeporteApiInterface happDeporteApi = HappDeporteApi.buildInstance();
        Call<List<User>> callUsers = happDeporteApi.getUsers(); //Para realizar la llamada y user el getTeams definido
        Log.d("users", "Llamada desde el model"); //Para depurar errores y ver si avanza o donde se para
        callUsers.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.d("user", "Llamada desde el model Ok"); //linea para depurar y ver que pasa
                List<User> users = response.body(); //Metemos la respuesta en una lista
                listener.onLoadTasksSuccess(users); //recibimos la lista por el listener
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("users", "Llamada desde model error"); //linea para depurar y ver que pasa
                t.printStackTrace();
                String message = "Error invocando a la operación";
                listener.onLoadTasksError(message); //recibimos los mensajes de error por listener
            }
        });
    }
}
