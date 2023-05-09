package com.svalero.happdeporteandroid.contract;

import com.svalero.happdeporteandroid.domain.FavTeam;
import com.svalero.happdeporteandroid.domain.Team;

import java.util.List;

/**
 * Declaramos la lógica las view y presenter que une ambas
 */
public interface FavTeamListContract {

    /**
     * Que necesita el model para solicitar a la API
     */
    interface Model {

        List<FavTeam> loadAllFavTeam();
//        boolean deleteFavTeam(long id);
    }

    /**
     * Que recibe la view después de solicitarle al presenter
     */
    interface View {
        void showFavTeams(List<FavTeam> favTeams);
        void showMessage(String message);
    }

    interface Presenter {
        void loadAllFavTeams();
//        void deleteFavTeams(long id);
    }


}
