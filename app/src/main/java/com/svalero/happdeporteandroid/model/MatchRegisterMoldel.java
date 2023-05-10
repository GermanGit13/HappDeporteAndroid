package com.svalero.happdeporteandroid.model;

import android.database.sqlite.SQLiteConstraintException;

import com.svalero.happdeporteandroid.api.HappDeporteApi;
import com.svalero.happdeporteandroid.api.HappDeporteApiInterface;
import com.svalero.happdeporteandroid.contract.MatchRegisterContract;
import com.svalero.happdeporteandroid.domain.Match;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *Implementamos el contract MatchRegisterContract.Model
 */
public class MatchRegisterMoldel implements MatchRegisterContract.Model {
    @Override
    public void registerMatch(long teamId, Match match, OnRegisterMatchListener listener) {
        try {
            HappDeporteApiInterface happDeporteApi = HappDeporteApi.buildInstance();
            Call<Match> callMatch = happDeporteApi.addMatch(teamId, match);
            callMatch.enqueue(new Callback<Match>() {
                @Override
                public void onResponse(Call<Match> call, Response<Match> response) {
                    Match match = response.body();
                    listener.onRegisterSuccess(match);
                }

                @Override
                public void onFailure(Call<Match> call, Throwable t) {
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
