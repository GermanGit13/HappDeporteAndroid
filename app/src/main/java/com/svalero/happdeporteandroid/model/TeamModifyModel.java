package com.svalero.happdeporteandroid.model;

import android.database.sqlite.SQLiteConstraintException;

import com.svalero.happdeporteandroid.api.HappDeporteApi;
import com.svalero.happdeporteandroid.api.HappDeporteApiInterface;
import com.svalero.happdeporteandroid.contract.TeamModifyContract;
import com.svalero.happdeporteandroid.contract.UserModifyContract;
import com.svalero.happdeporteandroid.domain.Team;
import com.svalero.happdeporteandroid.domain.User;
import com.svalero.happdeporteandroid.presenter.TeamModifyPresenter;
import com.svalero.happdeporteandroid.presenter.UserModifyPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamModifyModel implements TeamModifyContract.Model {

    private TeamModifyPresenter presenter;

    @Override
    public void modifyTeam(long teamId, long userId, Team team, TeamModifyContract.Model.OnModifyTeamListener listener) {

        try {
            HappDeporteApiInterface happDeporteApi = HappDeporteApi.buildInstance();
            Call<Team> callTeams= happDeporteApi.modifyTeam(teamId, userId, team);
            callTeams.enqueue(new Callback<Team>() {
                @Override
                public void onResponse(Call<Team> call, Response<Team> response) {
                    listener.onModifySuccess(team);
                }

                @Override
                public void onFailure(Call<Team> call, Throwable t) {
                    t.printStackTrace();
                    String message = "Error invocando a la operación";
                    listener.onModifyError(message);
                }
            });
        } catch (SQLiteConstraintException sce) {
            sce.printStackTrace();
        }
    }
}

