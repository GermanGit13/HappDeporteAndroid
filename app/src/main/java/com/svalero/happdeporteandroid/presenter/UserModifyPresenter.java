package com.svalero.happdeporteandroid.presenter;

import com.svalero.happdeporteandroid.contract.UserModifyContract;
import com.svalero.happdeporteandroid.domain.Match;
import com.svalero.happdeporteandroid.domain.User;
import com.svalero.happdeporteandroid.model.MatchRegisterMoldel;
import com.svalero.happdeporteandroid.model.UserModifyModel;
import com.svalero.happdeporteandroid.view.MatchRegisterView;
import com.svalero.happdeporteandroid.view.UserModifyView;

public class UserModifyPresenter implements UserModifyContract.Presenter, UserModifyContract.Model.OnModifyUserListener {

    private UserModifyModel model;
    private UserModifyView view;

    public UserModifyPresenter(UserModifyView view) {
        this.model = new UserModifyModel();
        this.view = view;
    }

    @Override
    public void onModifySuccess(User user) {
        view.showMessage("El Usuario se ha modificado correctamente");
    }

    @Override
    public void onModifyError(String message) {
        view.showError("Se ha producido un error al modificar usuario Inténtalo de nuevo");
    }

    @Override
    public void modifyUser(long userId, User user) {
        model.modifyUser(userId, user, this);
    }
}

