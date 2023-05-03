package com.svalero.happdeporteandroid.contract;

import com.svalero.happdeporteandroid.domain.Team;

import java.util.List;

/**
 * Declaramos la lógica las view y presenter que une ambas
 */
public interface TeamListContract {

    /**
     * Que necesita el model para solicitar a la API
     */
    interface Model {
        interface OnLoadTeamsListener { //
            void onLoadTasksSuccess(List<Team> teams); //para devolver la lista de tareas
            void onLoadTasksError(String message); //para devolver un posible error
        }
        void loadAllTeams(OnLoadTeamsListener listener); //quien le llame tiene que tener un listener para que le chive lo que ha pasado
    }

    /**
     * Que recibe la view después de solicitarle al presenter
     */
    interface View {
        void showTeams(List<Team> teams);
        void showMessage(String message);
    }

    interface Presenter {
        void loadAllTeams();
    }


}
