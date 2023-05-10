package com.svalero.happdeporteandroid.presenter;

import com.svalero.happdeporteandroid.contract.TeamListContract;
import com.svalero.happdeporteandroid.domain.Team;
import com.svalero.happdeporteandroid.model.TeamListModel;
import com.svalero.happdeporteandroid.view.TeamListView;

import java.util.List;

/**
 * Implementamos el contrato y el listener
 */
public class TeamListPresenter implements TeamListContract.Presenter,
    TeamListContract.Model.OnLoadTeamsListener{

    /**
     * Le pasamos el model y la view ya que es el único que conoce a ambos
     */
    private TeamListModel model;
    private TeamListView view;

    /**
     * Constructor para pasarle ambas cosas
     */
    public TeamListPresenter(TeamListView view) {
        this.view = view; //le pasamos la vista desde el presenter al modelo
        this.model = new TeamListModel(view.getApplicationContext()); //le pasamos el contexto
    }

    /**
     * Método que llama al model para pedirle el listado de equipos
     */
    @Override
    public void loadAllTeams() {
        model.loadAllTeams(this); //llamamos al models
    }

    @Override
    public void onLoadTasksSuccess(List<Team> teams) {
        view.showTeams(teams);
    }

    @Override
    public void onLoadTasksError(String message) {
        view.showMessage(message);
    }
}
