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

//    @GET("users/{userId}")
//    Call<User> getUserId(@Path("userId") long userId); //devuelve una lista de usuarios

    @POST("users")
    Call<User> addUser(@Body User user);

    @DELETE("users/{userId}")
    Call<Void> deleteUser(@Path("userId") long userId); //Void porque la operación de borrado no devuelve nada

    @PUT("/users/{userId}")
    Call<User> modifyUser(@Path("userId") long userId, @Body User user);

    /**
     * Teams
     */
    @GET("teams")
    Call<List<Team>> getTeams(); //devuelve una lista de equipos

    @POST("users/{userId}/teams")
    Call<Team> addTeam(@Path("userId") long userId, @Body Team team); //Le pasamos el id del usuario por PathVariable y el cuerpo del equipo

    @DELETE("teams/{teamId}")
    Call<Void> deleteTeam(@Path("teamId") long teamId); //Void porque la operación de borrado no devuelve nada
    @PUT("teams/{teamId}/users/{userId}")
    Call<Team> modifyTeam(@Path("teamId") long teamId, @Path("userId") long userId, @Body Team team);

    /**
     * Mactch
     */
    @GET("matches")
    Call<List<Match>> getMatches(); //devuelve una lista de partidos

    @POST("teams/{teamId}/matches")
    Call<Match> addMatch(@Path("teamId") long teamId, @Body Match match); //Le pasamos el id del equipo por PathVariable y el cuerpo del Partido

    @DELETE("matches/{matchId}")
    Call<Void> deleteMatch(@Path("matchId") long matchId); //Void porque la operación de borrado no devuelve nada
}
