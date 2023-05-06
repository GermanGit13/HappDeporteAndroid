package com.svalero.happdeporteandroid.contract;


import com.svalero.happdeporteandroid.domain.User;

public interface UserModifyContract {

    interface Model {
        interface OnRegisterUserListener { //Creamos un listener para devolver el Equipo creado  si xtodo va bien o el error si va mal
            void onRegisterSuccess(User user);
            void onRegisterError(String message);
        }
        void modifyUser(long userId, User user, UserModifyContract.Model.OnRegisterUserListener listener);
    }

    interface View {
        void showError(String errorMessage);
        void showMessage(String message);
        void resetForm(); //para resetear los datos de la ventana
    }

    interface Presenter {
        void modifyUser(long userId, User user);
    }
}

