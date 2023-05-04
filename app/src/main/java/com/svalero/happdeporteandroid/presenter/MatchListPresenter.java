package com.svalero.happdeporteandroid.presenter;

import com.svalero.happdeporteandroid.contract.MatchListContract;
import com.svalero.happdeporteandroid.contract.UserListContract;
import com.svalero.happdeporteandroid.domain.Match;
import com.svalero.happdeporteandroid.domain.User;
import com.svalero.happdeporteandroid.model.MatchListModel;
import com.svalero.happdeporteandroid.model.UserListModel;
import com.svalero.happdeporteandroid.view.MatchListView;
import com.svalero.happdeporteandroid.view.UserListView;

import java.util.List;

/**
 * Extiende de AppCompatActivity: donde hay un motón de código para usar por esos sobreescribimos los métodos de esta clase
 * Implementa el MatchListContract.View con sus métodos declarados en el contract
 */
public class MatchListPresenter implements MatchListContract.Presenter,
    MatchListContract.Model.OnLoadMatchListener{

    private MatchListModel model;
    private MatchListContract.View view; //le decimos que le pasamos un TaskListContract.View para que acepte varias activity distintas

//    /**
//     * Le pasamos el model y la view ya que es el único que conoce a ambos
//     */
//    private MatchListModel model;
//    private MatchListView view;

    /**
     * Constructor para pasarle ambas cosas
     */
    public MatchListPresenter(MatchListContract.View view) {
        this.view = view; //le pasamos la vista desde el presenter al modelo
        this.model = new MatchListModel();
    }

    /**
     * Método que llama al model para pedirle el listado de partidos
     */
    @Override
    public void loadAllMatches() {
        model.loadAllMatches(this); //llamamos al models
    }

    @Override
    public void onLoadTasksSuccess(List<Match> matches) {
        view.showMatches(matches);
    }

    @Override
    public void onLoadTasksError(String message) {
        view.showMessage(message);
    }
}
