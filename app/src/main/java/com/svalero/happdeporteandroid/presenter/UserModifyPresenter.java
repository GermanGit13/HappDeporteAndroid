package com.svalero.happdeporteandroid.presenter;

import com.svalero.happdeporteandroid.contract.UserModifyContract;
import com.svalero.happdeporteandroid.domain.User;
import com.svalero.happdeporteandroid.model.UserModifyModel;
import com.svalero.happdeporteandroid.view.UserModifyView;
//
//public class UserModifyPresenter implements UserModifyContract.Presenter, UserModifyContract.Model.OnModifyUserListener {
//
//    private UserModifyModel model;
//    private UserModifyView view;
//
//    public UserModifyPresenter(UserModifyView view) {
//        this.model = new UserModifyModel();
//        this.view = view;
//    }
//
//    @Override
//    public void onModifySuccess(User user) {
//        view.showMessage("El usuario " + user.getId() + " se ha modificado correctamente");
//    }
//
//    @Override
//    public void onModifyError(String message) {
//        view.showError("Se ha producido un error al modificar el usuario. Inténtalo de nuevo");
//    }
//
//    @Override
//    public void loadById(long userId) {
//
//    }
//
//    @Override
//    public void modifyUser(long userId, User user) {
//        model.modifyUser(userId, user, this);
//    }
//}
