package com.svalero.happdeporteandroid.presenter;

import com.svalero.happdeporteandroid.adapter.TeamAdapter;
import com.svalero.happdeporteandroid.adapter.UserAdapter;
import com.svalero.happdeporteandroid.contract.TeamDeleteContract;
import com.svalero.happdeporteandroid.contract.UserDeleteContract;
import com.svalero.happdeporteandroid.model.TeamDeleteModel;
import com.svalero.happdeporteandroid.model.UserDeleteModel;

public class UserDeletePresenter implements UserDeleteContract.Presenter,
        UserDeleteContract.Model.OnDeleteUserListener {

    private UserDeleteModel model;
    private UserAdapter view; //La view es el adapter porque realizamos el borrado desde un boton

    public UserDeletePresenter(UserAdapter view) {
        model = new UserDeleteModel();
        this.view = view;
    }

    @Override
    public void deleteUser(long userId) {
        model.deleteUser(userId, this);
    }

    @Override
    public void onDeleteSuccess() {
        view.showMessage("El Usuario se ha eliminado correctamente");
    }

    @Override
    public void onDeleteError(String message) {
        view.showError("Se ha producido un error al eliminar el usuario. Inténtalo de nuevo");
    }
}
