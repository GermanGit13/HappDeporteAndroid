package com.svalero.happdeporteandroid.contract;

import com.svalero.happdeporteandroid.domain.Team;
import com.svalero.happdeporteandroid.domain.User;

import java.util.List;

/**
 * Declaramos la lógica las view y presenter que une ambas
 */
public interface UserListContract {

    /**
     * Que necesita el model para solicitar a la API
     */
    interface Model {
        interface OnLoadUserListener { //
            void onLoadTasksSuccess(List<User> users); //para devolver la lista de usuarios
            void onLoadTasksError(String message); //para devolver un posible error
        }
        void loadAllUsers(OnLoadUserListener listener); //quien le llame tiene que tener un listener para que le chive lo que ha pasado
    }

    /**
     * Que recibe la view después de solicitarle al presenter
     */
    interface View {
        void showUsers(List<User> users);
        void showMessage(String message);
    }

    interface Presenter {
        void loadAllUsers();
    }
}
