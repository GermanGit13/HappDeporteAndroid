package com.svalero.happdeporteandroid.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.svalero.happdeporteandroid.R;
import com.svalero.happdeporteandroid.adapter.TeamAdapter;
import com.svalero.happdeporteandroid.contract.TeamListContract;
import com.svalero.happdeporteandroid.domain.Team;
import com.svalero.happdeporteandroid.presenter.TeamListPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Extiende de AppCompatActivity: donde hay un motón de código para usar por esos sobreescribimos los métodos de esta clase
 * Implementa el TeamListContract.View con sus métodos declarados en el contract
 */
public class TeamListView extends AppCompatActivity implements TeamListContract.View {

    private List<Team> teamList; //Creamos la lista que recibiremos
    private TeamAdapter adapter; //Declaramos el adapter
    private TeamListPresenter presenter; //declaramos el presenter para solicitar los datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list_view);

        presenter = new TeamListPresenter(this); //instanciamos el presenter y le pasamos el contexto

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
        adapter = new TeamAdapter(this, teamList); //se lo pasamos al adapter para que pinte los datos de cada equipo de la lista en el item
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("teams", "Llamada desde view"); //depurar para ver hasta donde llego
        presenter.loadAllTeams(); //le decimos al presenter cuando vuelve del resume que carge xtodo
    }



    @Override
    public void showTeams(List<Team> teams) {
        teamList.clear(); //limpiamos la lista por si tuviera datos de antes
        teamList.addAll(teams); //añadimos la lista que recibimos a la lista que teniamos
        adapter.notifyDataSetChanged();//notificamos al adapter de los cambios

    }

//TODO falta public void continueButton(View view)

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//        super.onPointerCaptureChanged(hasCapture);
//    }
}