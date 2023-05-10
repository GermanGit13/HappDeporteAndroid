package com.svalero.happdeporteandroid.contract;

import com.svalero.happdeporteandroid.domain.Match;
import com.svalero.happdeporteandroid.domain.User;
import com.svalero.happdeporteandroid.model.UserModifyModel;

public interface UserModifyContract {

    interface Model {
        interface OnModifyUserListener { //Creamos un listener para devolver el User modificado  si xtodo va bien o el error si va mal
            void onModifySuccess(User user);
            void onModifyError(String message);
        }
        void modifyUser (long userId, User user, UserModifyContract.Model.OnModifyUserListener listener);
    }

    interface View {
        void showError(String errorMessage);
        void showMessage(String message);
    }

    interface Presenter {
        void modifyUser(long userId, User user);
    }
}