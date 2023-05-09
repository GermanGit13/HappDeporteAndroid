package com.svalero.happdeporteandroid.presenter;

import com.svalero.happdeporteandroid.adapter.FavTeamAdapter;
import com.svalero.happdeporteandroid.contract.FavTeamDeleteContract;
import com.svalero.happdeporteandroid.domain.FavTeam;
import com.svalero.happdeporteandroid.model.FavTeamDeleteModel;


public class FavTeamDeletePresenter implements FavTeamDeleteContract.Presenter  {
    private FavTeamDeleteModel model;
    private FavTeamAdapter view; //La view es el adapter porque realizamos el borrado desde un boton

    public FavTeamDeletePresenter(FavTeamDeleteModel model, FavTeamAdapter view) {
        this.model = new FavTeamDeleteModel(view.getContext()); //le pasamos el contexto al model
        this.view = view;
    }

    @Override
    public void deleteFavTeam(FavTeam favTeam) {
        model.deleteFavTeam(favTeam);
    }

}
