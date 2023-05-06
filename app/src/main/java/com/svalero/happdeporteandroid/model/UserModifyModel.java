package com.svalero.happdeporteandroid.model;

import android.database.sqlite.SQLiteConstraintException;

import com.svalero.happdeporteandroid.api.HappDeporteApi;
import com.svalero.happdeporteandroid.api.HappDeporteApiInterface;
import com.svalero.happdeporteandroid.contract.UserModifyContract;
import com.svalero.happdeporteandroid.domain.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserModifyModel implements UserModifyContract.Model {

    @Override
    public void modifyUser(long userId, User user, OnRegisterUserListener listener) {
        try {
            HappDeporteApiInterface happDeporteApi = HappDeporteApi.buildInstance();
            Call<User> callUsers = happDeporteApi.modifyUser(userId, user);
            callUsers.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    listener.onRegisterSuccess(user);
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
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
