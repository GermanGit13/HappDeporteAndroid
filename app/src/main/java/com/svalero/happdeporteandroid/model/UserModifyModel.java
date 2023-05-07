package com.svalero.happdeporteandroid.model;

import android.database.sqlite.SQLiteConstraintException;
import android.widget.EditText;

import com.svalero.happdeporteandroid.api.HappDeporteApi;
import com.svalero.happdeporteandroid.api.HappDeporteApiInterface;
import com.svalero.happdeporteandroid.contract.UserModifyContract;
import com.svalero.happdeporteandroid.domain.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserModifyModel  {

//    @Override
//    public void modifyUser(long userId, User user, OnModifyUserListener listener) {
//        try {
//            HappDeporteApiInterface happDeporteApi = HappDeporteApi.buildInstance();
//            Call<User> callUsers = happDeporteApi.modifyUser(userId, user);
//            callUsers.enqueue(new Callback<User>() {
//                @Override
//                public void onResponse(Call<User> call, Response<User> response) {
//                    listener.onModifySuccess(user);
//                }
//
//                @Override
//                public void onFailure(Call<User> call, Throwable t) {
//                    t.printStackTrace();
//                    String message = "Error invocando a la operación";
//                    listener.onModifyError(message);
//                }
//            });
//        } catch (SQLiteConstraintException sce) {
//            sce.printStackTrace();
//        }
//    }

//    @Override
//    public void loadUsers(long userId, OnFindIdUserListener listener) {
//        try {
//            HappDeporteApiInterface happDeporteApi = HappDeporteApi.buildInstance();
//            Call<User> callUsers = happDeporteApi.modifyUser(userId);
//            callUsers.enqueue(new Callback<User>() {
//                @Override
//                public void onResponse(Call<User> call, Response<User> response) {
//                    listener.(user);
//                }
//
//                @Override
//                public void onFailure(Call<User> call, Throwable t) {
//                    t.printStackTrace();
//                    String message = "Error invocando a la operación";
//                    listener.onModifyError(message);
//                }
//            });
//        } catch (SQLiteConstraintException sce) {
//            sce.printStackTrace();
//        }

}
