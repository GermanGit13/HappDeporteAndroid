package com.svalero.happdeporteandroid.contract;

import com.svalero.happdeporteandroid.domain.Match;

/**
 * Declaramos la lógica las view y presenter que une ambas
 */
public interface MatchRegisterContract {

    interface Model {
        interface OnRegisterMatchListener { //Creamos un listener para devolver el Match creado  si xtodo va bien o el error si va mal
            void onRegisterSuccess(Match match);
            void onRegisterError(String message);
        }
        void registerMatch(long IdTeam, Match match, OnRegisterMatchListener listener);
    }

    interface View {
        void showError(String errorMessage);
        void showMessage(String message);
        void resetForm(); //para resetear los datos de la ventana
    }

    interface Presenter {
        void registerMatch(long IdTeam, Match match);
    }
}
