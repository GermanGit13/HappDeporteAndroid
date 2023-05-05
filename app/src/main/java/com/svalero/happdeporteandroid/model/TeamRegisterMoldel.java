package com.svalero.happdeporteandroid.model;

import android.database.sqlite.SQLiteConstraintException;

import com.svalero.happdeporteandroid.api.HappDeporteApi;
import com.svalero.happdeporteandroid.api.HappDeporteApiInterface;
import com.svalero.happdeporteandroid.contract.MatchRegisterContract;
import com.svalero.happdeporteandroid.contract.TeamRegisterContract;
import com.svalero.happdeporteandroid.domain.Match;
import com.svalero.happdeporteandroid.domain.Team;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *Implementamos el contract TeamRegisterContract.Model
 */
public class TeamRegisterMoldel implements TeamRegisterContract.Model {
    @Override
    public void registerTeam(long userId, Team team, OnRegisterTeamListener listener) {
        try {
            HappDeporteApiInterface happDeporteApi = HappDeporteApi.buildInstance();
            Call<Team> callTeam = happDeporteApi.addTeam(userId, team);
            callTeam.enqueue(new Callback<Team>() {
                @Override
                public void onResponse(Call<Team> call, Response<Team> response) {
                    Team team = response.body();
                    listener.onRegisterSuccess(team);
                }

                @Override
                public void onFailure(Call<Team> call, Throwable t) {
                    t.printStackTrace();
                    String message = "Error invocando a la operación";
                    listener.onRegisterError(message);
                }
            });
        } catch (SQLiteConstraintException sce) {
            sce.printStackTrace();
        }

    }
}
