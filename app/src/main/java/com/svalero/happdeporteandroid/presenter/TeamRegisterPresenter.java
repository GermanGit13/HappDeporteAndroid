package com.svalero.happdeporteandroid.presenter;

import com.svalero.happdeporteandroid.contract.MatchRegisterContract;
import com.svalero.happdeporteandroid.contract.TeamRegisterContract;
import com.svalero.happdeporteandroid.domain.Match;
import com.svalero.happdeporteandroid.domain.Team;
import com.svalero.happdeporteandroid.model.MatchRegisterMoldel;
import com.svalero.happdeporteandroid.model.TeamRegisterMoldel;
import com.svalero.happdeporteandroid.view.MatchRegisterView;
import com.svalero.happdeporteandroid.view.TeamRegisterView;

/**
 * Implementamos el contrato y el listener
 */
public class TeamRegisterPresenter implements TeamRegisterContract.Presenter, TeamRegisterContract.Model.OnRegisterTeamListener {

    /**
     * Le pasamos el model y la view ya que es el único que conoce a ambos
     */
    private TeamRegisterMoldel model;
    private TeamRegisterView view;

    /**
     * Constructor para pasarle ambas cosas
     */
    public TeamRegisterPresenter(TeamRegisterView view) {
        this.model = new TeamRegisterMoldel();
        this.view = view;
    }

    @Override
    public void registerTeam(long userId, Team team) {
        model.registerTeam(userId, team, this);

    }

    @Override
    public void onRegisterSuccess(Team team) {
        view.showMessage("El equipo " + team.getId() + " se ha registrado correctamente");
    }

    @Override
    public void onRegisterError(String message) {
        view.showError("Se ha producido un error al registrar el partido. Inténtalo de nuevo");
    }
}
