package com.svalero.happdeporteandroid.api;

import com.svalero.happdeporteandroid.domain.Match;
import com.svalero.happdeporteandroid.domain.Team;
import com.svalero.happdeporteandroid.domain.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Para definir las operaciones que queremos dar visibilidad en nuestro Aplicacion android provenientes de la API
 */
public interface HappDeporteApiInterface {

    @GET("teams")
    Call<List<Team>> getTeams(); //devuelve una lista de equipos

    @GET("users")
    Call<List<User>> getUsers(); //devuelve una lista de usuarios

    @GET("matches")
    Call<List<Match>> getMatches(); //devuelve una lista de partidos

    @POST("/teams/{teamId}/matches")
    Call<Match> addMatch(@Path("teamInMatch") long teamId, @Body Match match); //Le pasamos el id del equipo por PathVariable y el cuerpo del Partido
}
