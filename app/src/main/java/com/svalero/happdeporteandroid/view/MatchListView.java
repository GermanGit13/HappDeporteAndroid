package com.svalero.happdeporteandroid.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.svalero.happdeporteandroid.R;
import com.svalero.happdeporteandroid.adapter.MatchAdapter;
import com.svalero.happdeporteandroid.adapter.TeamAdapter;
import com.svalero.happdeporteandroid.contract.MatchListContract;
import com.svalero.happdeporteandroid.domain.Match;
import com.svalero.happdeporteandroid.domain.Team;
import com.svalero.happdeporteandroid.presenter.MatchListPresenter;
import com.svalero.happdeporteandroid.presenter.TeamListPresenter;

import java.util.ArrayList;
import java.util.List;

public class MatchListView extends AppCompatActivity implements MatchListContract.View {

    private List<Match> matchList; //Creamos la lista que recibiremos
    private MatchAdapter adapter; //Declaramos el adapter
    private MatchListPresenter presenter; //declaramos el presenter para solicitar los datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_list_view);

        presenter = new MatchListPresenter(this); //instanciamos el presenter y le pasamos el contexto

        initializeRecyclerView();
    }

    /**
     * Método para inicializar el RecyclerView
     */
    private void initializeRecyclerView() {
        matchList = new ArrayList<>();

        RecyclerView recyclerView = findViewById(R.id.rc_match_all);// recreamos un onjeto RecyclerView y le pasamos el id del creado en el layout activity_match_list_view.xml
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MatchAdapter(this, matchList); //se lo pasamos al adapter para que pinte los datos de cada equipo de la lista en el item
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("matches", "Llamada desde view"); //depurar para ver hasta donde llego
        presenter.loadAllMatches(); //le decimos al presenter cuando vuelve del resume que carge xtodo
    }

    @Override
    public void showMatches(List<Match> matches) {
        matchList.clear(); //limpiamos la lista por si tuviera datos de antes
        matchList.addAll(matches); //añadimos la lista que recibimos a la lista que teniamos
        adapter.notifyDataSetChanged();//notificamos al adapter de los cambios

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}