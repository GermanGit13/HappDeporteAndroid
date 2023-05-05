package com.svalero.happdeporteandroid.api;

import com.svalero.happdeporteandroid.domain.Match;
import com.svalero.happdeporteandroid.domain.Team;
import com.svalero.happdeporteandroid.domain.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Para definir las operaciones que queremos dar visibilidad en nuestro Aplicacion android provenientes de la API
 */
public interface HappDeporteApiInterface {

    /**
     * Users
     */
    @GET("users")
    Call<List<User>> getUsers(); //devuelve una lista de usuarios

    @POST("users")
    Call<User> aadUser(@Body User user);

    @DELETE("users/{id}")
    Call<Void> deleteUser(@Path("id") long id);


    /**
     * Teams
     */
    @GET("teams")
    Call<List<Team>> getTeams(); //devuelve una lista de equipos

    @POST("users/{userId}/teams")
    Call<Team> addTeam(@Path("userId") long userId, @Body Team team); //Le pasamos el id del usuario por PathVariable y el cuerpo del equipo

    /**
     * Mactch
     */
    @GET("matches")
    Call<List<Match>> getMatches(); //devuelve una lista de partidos

    @POST("teams/{teamId}/matches")
    Call<Match> addMatch(@Path("teamId") long teamId, @Body Match match); //Le pasamos el id del equipo por PathVariable y el cuerpo del Partido
}
