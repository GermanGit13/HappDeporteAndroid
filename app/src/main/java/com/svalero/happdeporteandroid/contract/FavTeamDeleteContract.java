package com.svalero.happdeporteandroid.contract;

import com.svalero.happdeporteandroid.domain.FavTeam;

public interface FavTeamDeleteContract {

    interface Model {
        boolean deleteFavTeam(FavTeam favTeam);
    }

    interface View {
        void showMessage(String message);
    }

    interface Presenter {
        void deleteTask(FavTeam favTeam);
    }
}
