package com.svalero.happdeporteandroid.contract;

public interface TeamDeleteContract {

    interface Model {
        interface OnDeleteTeamListener {
            void onDeleteSucces();
            void onDeleteError(String message);
        }
        void deleteTeam(long teamId, OnDeleteTeamListener listener);
    }

    interface View {
        void showError(String errorMessage);
        void showMessage(String message);
    }

    interface Presenter {
        void deleteTeam(long teamId);
    }
}
