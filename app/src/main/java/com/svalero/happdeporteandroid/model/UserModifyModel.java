package com.svalero.happdeporteandroid.model;

import android.database.sqlite.SQLiteConstraintException;
import android.widget.EditText;

import com.svalero.happdeporteandroid.api.HappDeporteApi;
import com.svalero.happdeporteandroid.api.HappDeporteApiInterface;
import com.svalero.happdeporteandroid.contract.UserModifyContract;
import com.svalero.happdeporteandroid.domain.User;
import com.svalero.happdeporteandroid.presenter.UserModifyPresenter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserModifyModel implements UserModifyContract.Model {

    private UserModifyPresenter presenter;

    @Override
    public void modifyUser(long userId, User user, OnModifyUserListener listener) {

        try {
            HappDeporteApiInterface happDeporteApi = HappDeporteApi.buildInstance();
            Call<User> callUsers = happDeporteApi.modifyUser(userId, user);
            callUsers.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    listener.onModifySuccess(user);
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
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

