package com.svalero.happdeporteandroid.contract;

import com.svalero.happdeporteandroid.domain.Team;

/**
 * Declaramos la lógica las view y presenter que une ambas
 */
public interface TeamRegisterContract {

    interface Model {
        interface OnRegisterTeamListener { //Creamos un listener para devolver el Equipo creado  si xtodo va bien o el error si va mal
            void onRegisterSuccess(Team team);
            void onRegisterError(String message);
        }
        void registerTeam(long userId, Team team, OnRegisterTeamListener listener);
    }

    interface View {
        void showError(String errorMessage);
        void showMessage(String message);
        void resetForm(); //para resetear los datos de la ventana
    }

    interface Presenter {
        void registerTeam(long userId, Team team);
    }
}
