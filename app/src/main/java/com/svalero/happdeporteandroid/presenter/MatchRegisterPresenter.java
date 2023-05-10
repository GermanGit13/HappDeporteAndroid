package com.svalero.happdeporteandroid.presenter;

import com.svalero.happdeporteandroid.contract.MatchRegisterContract;
import com.svalero.happdeporteandroid.domain.Match;
import com.svalero.happdeporteandroid.model.MatchRegisterMoldel;
import com.svalero.happdeporteandroid.view.MatchRegisterView;

/**
 * Implementamos el contrato y el listener
 */
public class MatchRegisterPresenter implements MatchRegisterContract.Presenter, MatchRegisterContract.Model.OnRegisterMatchListener {

    /**
     * Le pasamos el model y la view ya que es el único que conoce a ambos
     */
    private MatchRegisterMoldel model;
    private MatchRegisterView view;

    /**
     * Constructor para pasarle ambas cosas
     */
    public MatchRegisterPresenter(MatchRegisterView view) {
        this.model = new MatchRegisterMoldel();
        this.view = view;
    }

    @Override
    public void registerMatch(long teamId, Match match) {
        model.registerMatch(teamId, match, this);

    }

    @Override
    public void onRegisterSuccess(Match match) {
//        view.showMessage("El partido " + match.getId() + " se ha registrado correctamente");
        view.showMessage("El partido  se ha registrado correctamente");
    }

    @Override
    public void onRegisterError(String message) {
        view.showError("Se ha producido un error al registrar el partido. Inténtalo de nuevo");
    }
}
