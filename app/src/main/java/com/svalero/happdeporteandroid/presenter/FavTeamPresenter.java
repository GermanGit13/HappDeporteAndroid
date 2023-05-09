package com.svalero.happdeporteandroid.presenter;

import com.svalero.happdeporteandroid.adapter.TeamAdapter;
import com.svalero.happdeporteandroid.contract.FavTeamRegisterContract;
import com.svalero.happdeporteandroid.domain.FavTeam;
import com.svalero.happdeporteandroid.model.FavTeamRegisterModel;

public class FavTeamPresenter implements FavTeamRegisterContract.Presenter {

    private FavTeamRegisterModel model;
    private TeamAdapter view;

    /**
     * le pasamos la view para tener el contexto al instanciar el presenter desde la view
     * @param view
     */
    public FavTeamPresenter(TeamAdapter view) {
        model = new FavTeamRegisterModel(); //le pasamos el contexto al model
        this.view = view;
    }

    @Override
    public void registerFavTeam(FavTeam favTeam) {
        boolean done = model.registerFavTeam(favTeam); //devolvemenos un true o false en funcion de lo que nos devuielva el model al intentar registrar
        if (done) {
            view.showMessage("Equipo añadido a Favoritos"); //Mensajes que le devolvemos a la view
//            view.resetForm(); //limpiamos el formulario
        } else {
            view.showError("Se ha producido un error al añadir a favoritos. Comprueba que los datos son correctos");
        }
    }
}
