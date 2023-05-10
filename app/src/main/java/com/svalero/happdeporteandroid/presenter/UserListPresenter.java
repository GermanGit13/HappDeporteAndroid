package com.svalero.happdeporteandroid.presenter;

import com.svalero.happdeporteandroid.contract.TeamListContract;
import com.svalero.happdeporteandroid.contract.UserListContract;
import com.svalero.happdeporteandroid.domain.Team;
import com.svalero.happdeporteandroid.domain.User;
import com.svalero.happdeporteandroid.model.TeamListModel;
import com.svalero.happdeporteandroid.model.UserListModel;
import com.svalero.happdeporteandroid.view.TeamListView;
import com.svalero.happdeporteandroid.view.UserListView;

import java.util.List;

/**
 * Implementamos el contrato y el listener
 */
public class UserListPresenter implements UserListContract.Presenter,
    UserListContract.Model.OnLoadUserListener{

    /**
     * Le pasamos el model y la view ya que es el único que conoce a ambos
     */
    private UserListModel model;
    private UserListView view;

    /**
     * Constructor para pasarle ambas cosas
     */
    public UserListPresenter(UserListView view) {
        this.view = view; //le pasamos la vista desde el presenter al modelo
        this.model = new UserListModel(view.getApplicationContext()); //le pasamos el contexto
    }

    /**
     * Método que llama al model para pedirle el listado de equipos
     */
    @Override
    public void loadAllUsers() {
        model.loadAllUsers(this); //llamamos al models
    }

    @Override
    public void onLoadTasksSuccess(List<User> users) {
        view.showUsers(users);
    }

    @Override
    public void onLoadTasksError(String message) {
        view.showMessage(message);
    }
}
