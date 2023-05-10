package com.svalero.happdeporteandroid.model;

import android.database.sqlite.SQLiteConstraintException;

import com.svalero.happdeporteandroid.api.HappDeporteApi;
import com.svalero.happdeporteandroid.api.HappDeporteApiInterface;
import com.svalero.happdeporteandroid.contract.TeamDeleteContract;
import com.svalero.happdeporteandroid.domain.Team;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamDeleteModel implements TeamDeleteContract.Model {

    @Override
    public void deleteTeam(long teamId, OnDeleteTeamListener listener) {
        try {
            HappDeporteApiInterface happDeporteApi = HappDeporteApi.buildInstance();
            Call<Void> callTeams = happDeporteApi.deleteTeam(teamId);
            callTeams.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    listener.onDeleteSuccess();
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    t.printStackTrace();
                    String message = "Error invocando a la operación";
                    listener.onDeleteError(message);
                }
            });
        } catch (SQLiteConstraintException sce) {
            sce.printStackTrace();
        }
    }
}
