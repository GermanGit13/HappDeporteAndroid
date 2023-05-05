package com.svalero.happdeporteandroid.presenter;

import com.svalero.happdeporteandroid.adapter.TeamAdapter;
import com.svalero.happdeporteandroid.contract.TeamDeleteContract;
import com.svalero.happdeporteandroid.model.TeamDeleteModel;
import com.svalero.happdeporteandroid.model.TeamRegisterMoldel;

public class TeamDeletePresenter implements TeamDeleteContract.Presenter,
        TeamDeleteContract.Model.OnDeleteTeamListener {

    private TeamDeleteModel model;
    private TeamAdapter view; //La view es el adapter porque realizamos el borrado desde un boton

    public TeamDeletePresenter(TeamAdapter view) {
        model = new TeamDeleteModel();
        this.view = view;
    }

    @Override
    public void deleteTeam(long teamId) {
        model.deleteTeam(teamId, this);
    }

    @Override
    public void onDeleteSucces() {
        view.showMessage("El Equipo se ha eliminado correctamente");
    }

    @Override
    public void onDeleteError(String message) {
        view.showError("Se ha producido un error al eliminar la tarea. Inténtalo de nuevo");
    }
}
