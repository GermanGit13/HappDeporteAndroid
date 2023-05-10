package com.svalero.happdeporteandroid.presenter;

import com.svalero.happdeporteandroid.contract.FavTeamListContract;
import com.svalero.happdeporteandroid.contract.FavTeamRegisterContract;
import com.svalero.happdeporteandroid.domain.FavTeam;
import com.svalero.happdeporteandroid.model.FavTeamListModel;
import com.svalero.happdeporteandroid.view.FavTeamListView;

import java.util.List;

public class FavTeamListPresenter implements FavTeamListContract.Presenter {

    private FavTeamListModel model;
    private FavTeamListView view;

    public FavTeamListPresenter(FavTeamListView view) {
        this.view = view;
        this.model = new FavTeamListModel(view.getApplicationContext());
    }


    @Override
    public void loadAllFavTeams() {
        List<FavTeam> favTeam  = model.loadAllFavTeam();
        view.showFavTeams(favTeam);
    }
}
