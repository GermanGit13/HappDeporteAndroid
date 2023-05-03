package com.svalero.happdeporteandroid.api;

import com.svalero.happdeporteandroid.domain.Team;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Para definir las operaciones que queremos dar visibilidad en nuestro Aplicacion android provenientes de la API
 */
public interface HappDeporteApiInterface {

    @GET("teams")
    Call<List<Team>> getTeams(); //devuelve una lista de equipos

}
