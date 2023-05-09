package com.svalero.happdeporteandroid.contract;

import com.svalero.happdeporteandroid.domain.FavTeam;

public interface FavTeamRegisterContract {

    /**
     * Lo que el model necesita hacer
     */
    interface Model {
        boolean registerFavTeam(FavTeam favTeam);
    }

    /**
     * Lo que la view necesita
     */
    interface View {
        void showError (String errorMessage);
        void showMessage (String message);
//        void resetForm();
    }

    interface Presenter {
        void registerFavTeam(FavTeam favTeam);
    }
}
