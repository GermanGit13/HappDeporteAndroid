package com.svalero.happdeporteandroid.contract;

import com.svalero.happdeporteandroid.domain.Team;

public interface TeamModifyContract {

    interface Model {
        interface OnModifyTeamListener { //Creamos un listener para devolver el User modificado  si xtodo va bien o el error si va mal
            void onModifySuccess(Team team);
            void onModifyError(String message);
        }
        void modifyTeam (long teamId, long userId, Team team, TeamModifyContract.Model.OnModifyTeamListener listener);
    }

    interface View {
        void showError(String errorMessage);
        void showMessage(String message);
    }

    interface Presenter {
        void modifyTeam(long teamId, long userId, Team team);
    }
}