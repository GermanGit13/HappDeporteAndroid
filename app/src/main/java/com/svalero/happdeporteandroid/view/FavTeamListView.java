package com.svalero.happdeporteandroid.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.svalero.happdeporteandroid.R;
import com.svalero.happdeporteandroid.adapter.FavTeamAdapter;
import com.svalero.happdeporteandroid.adapter.TeamAdapter;
import com.svalero.happdeporteandroid.contract.FavTeamListContract;
import com.svalero.happdeporteandroid.domain.FavTeam;
import com.svalero.happdeporteandroid.domain.Team;
import com.svalero.happdeporteandroid.presenter.FavTeamListPresenter;
import com.svalero.happdeporteandroid.presenter.TeamListPresenter;

import java.util.ArrayList;
import java.util.List;

public class FavTeamListView extends AppCompatActivity implements FavTeamListContract.View {

    private List<FavTeam> teamList; //Creamos la lista que recibiremos
    private FavTeamAdapter adapter; //Declaramos el adapter
    private FavTeamListPresenter presenter; //declaramos el presenter para solicitar los datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list_view);

        presenter = new FavTeamListPresenter(this); //instanciamos el presenter y le pasamos el contexto

        initializeRecyclerView(); //inicializamos el RecyclerView
    }

    /**
     * Método para inicializar el RecyclerView
     */
    private void initializeRecyclerView() {
        teamList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.rc_team_all);// recreamos un onjeto RecyclerView y le pasamos el id del creado en el layout activity_team_list_view.xml
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FavTeamAdapter(this, teamList); //se lo pasamos al adapter para que pinte los datos de cada equipo de la lista en el item
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("Favteams", "Llamada desde view"); //depurar para ver hasta donde llego
        presenter.loadAllFavTeams(); //le decimos al presenter cuando vuelve del resume que carge xtodo
    }



    @Override
    public void showFavTeams(List<FavTeam> favTeams) {
        teamList.clear(); //limpiamos la lista por si tuviera datos de antes
        teamList.addAll(favTeams); //añadimos la lista que recibimos a la lista que teniamos
        adapter.notifyDataSetChanged();//notificamos al adapter de los cambios

    }


    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    /**
     * PAra crear el menu (el actionBar)
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu); //Inflamos el menu
        return true;
    }

    /**
     * Para cuando elegimos una opcion del menu
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //TODO cambiar el botón de las preferencias y Mapas para llevarlo a su activity
        if (item.getItemId() == R.id.go_home) { //Evaluar a que opcion hemos pichado
            Intent intent = new Intent(this, MainActivity.class); //donde nos manda al pinchar sobre el boton + en el action bar
            startActivity(intent);
            return true;
        }
        else if (item.getItemId() == R.id.view_map) { //Para cuando pulsan en la boton del mapa en el actionbar
            Intent intent = new Intent(this, MapsActivity.class); //donde nos manda al pinchar sobre el boton mapas en el action bar
            startActivity(intent);
            return true;
        }  else if (item.getItemId() == R.id.go_fav) { //Para cuando pulsan en la boton del mapa en el actionbar
            Intent intent = new Intent(this, FavTeamListView.class); //donde nos manda al pinchar sobre el boton mapas en el action bar
            startActivity(intent);
            return true;
        }
        return false;
    }
}