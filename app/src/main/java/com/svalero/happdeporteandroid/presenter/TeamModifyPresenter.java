package com.svalero.happdeporteandroid.presenter;

import com.svalero.happdeporteandroid.contract.TeamModifyContract;
import com.svalero.happdeporteandroid.contract.UserModifyContract;
import com.svalero.happdeporteandroid.domain.Team;
import com.svalero.happdeporteandroid.domain.User;
import com.svalero.happdeporteandroid.model.TeamModifyModel;
import com.svalero.happdeporteandroid.model.UserModifyModel;
import com.svalero.happdeporteandroid.view.TeamModifyView;
import com.svalero.happdeporteandroid.view.UserModifyView;

public class TeamModifyPresenter implements TeamModifyContract.Presenter, TeamModifyContract.Model.OnModifyTeamListener {

    private TeamModifyModel model;
    private TeamModifyView view;

    public TeamModifyPresenter(TeamModifyView view) {
        this.model = new TeamModifyModel();
        this.view = view;
    }

    @Override
    public void onModifySuccess(Team team) {
        view.showMessage("El Usuario se ha modificado correctamente");
    }

    @Override
    public void onModifyError(String message) {
        view.showError("Se ha producido un error al modificar usuario Inténtalo de nuevo");
    }

    @Override
    public void modifyTeam(long teamId, long userId, Team team) {
        model.modifyTeam(teamId, userId, team, this);
    }
}

