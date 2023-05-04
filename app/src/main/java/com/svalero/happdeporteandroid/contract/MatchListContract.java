package com.svalero.happdeporteandroid.contract;

import com.svalero.happdeporteandroid.domain.Match;
import com.svalero.happdeporteandroid.domain.User;

import java.util.List;

/**
 * Declaramos la lógica las view y presenter que une ambas
 */
public interface MatchListContract {

    /**
     * Que necesita el model para solicitar a la API
     */
    interface Model {
        interface OnLoadMatchListener { //
            void onLoadTasksSuccess(List<Match> matches); //para devolver la lista de partidos
            void onLoadTasksError(String message); //para devolver un posible error
        }
        void loadAllMatches(OnLoadMatchListener listener); //quien le llame tiene que tener un listener para que le chive lo que ha pasado
    }

    /**
     * Que recibe la view después de solicitarle al presenter
     */
    interface View {
        void showMatches(List<Match> matches);
        void showMessage(String message);
    }

    interface Presenter {
        void loadAllMatches();
    }
}
