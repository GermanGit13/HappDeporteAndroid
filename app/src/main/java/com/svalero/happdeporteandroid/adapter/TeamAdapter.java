package com.svalero.happdeporteandroid.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.mapbox.maps.Task;
import com.svalero.happdeporteandroid.R;
import com.svalero.happdeporteandroid.contract.TeamDeleteContract;
import com.svalero.happdeporteandroid.domain.Team;
import com.svalero.happdeporteandroid.presenter.TeamDeletePresenter;
import com.svalero.happdeporteandroid.view.MatchRegisterView;

import java.util.List;

/**
 * TeamAdapter: Es la clase en la que le explicamos a Android como pintar cada elemento en el RecyclerView
 * Patron Holder: 1) Constructor - 2) onCreateViewHolder - 3) onBindViewHolder - 4) getItemCount - 5) Y la estructura SuperheroHolder
 * al extender de la clase RecyclerView los @Override los añadira automáticamente para el patron Holder, solo añadiremos nosotros el 5)
 * implements TeamDeleteContract.View porque hace las funciones de view para implentar sus metodos
 */
public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamHolder> implements TeamDeleteContract.View {

    private Context context; // Activity en la que estamos
    private List<Team> teamList;
    private Team team;
    private View snackBarView;
    private TeamDeletePresenter presenter;

    /**
     * 1) Constructor que creamos para pasarle los datos que queremos que pinte
     * el contexto y la lista de equipos
     * @param dataList Lista de equipos que le pasamos
     */
    public TeamAdapter(Context context, List<Team> dataList) {
        this.context = context;
        this.teamList = dataList;
    }

    /**
     * Metodo con el que Android va a inflar, va a crear cada estructura del layout donde irán los datos de cada equipo.
     * Vista detalle de cada equipo
     */
    @Override
    public TeamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.team_item, parent, false); // el layout team_item para cada equipo
        return new TeamHolder(view); //Creamos un holder para cada una de las estructuras que infla el layout
    }

    /**
     * Metodo que estamos obligados para hacer corresponder los valores de la lista y pintarlo en cada elemento de layout
     * es para poder recorrer en el bucle por cada elemento de la lista y poder pintarlo
     */
    @Override
    public void onBindViewHolder(TeamHolder holder, int position) {
        holder.teamId.setText(String.valueOf(teamList.get(position).getId()));
        holder.teamCategory.setText(teamList.get(position).getCategory());
        holder.teamCompetition.setText(teamList.get(position).getCompetition());
        holder.teamCuota.setText(String.valueOf(teamList.get(position).getCuota())); //Proviene de un double
        holder.teamDayTrain.setText(teamList.get(position).getDayTrain());
        holder.teamStartTrain.setText(teamList.get(position).getStartTrain());
        holder.teamEndTrain.setText(teamList.get(position).getEndTrain());
        holder.teamActive.setChecked(teamList.get(position).isActive()); //Proviene de un boolean acaba en un checkbox
//        holder.teamUser.setText(String.valueOf(teamList.get(position).getUser().getName()));

    }

    /**
     * Metodo que estamos obligados a hacer para que devuelva el número de elementos y android pueda hacer sus calculos y pintar xtodo en base a esos calculos
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return teamList.size(); //devolvemos el tamaño de la lista
    }

    @Override
    public void showError(String errorMessage) {
        Snackbar.make(snackBarView, errorMessage,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    @Override
    public void showMessage(String message) {
        Snackbar.make(snackBarView, message,
                BaseTransientBottomBar.LENGTH_LONG).show();
    }

    /**
     * 5) Holder son las estructuras que contienen los datos y los rellenan luego
     * Creamos todos los componentes que tenemos
     */
    public class TeamHolder extends RecyclerView.ViewHolder {
        public TextView teamId;
        public TextView teamCategory;
        public TextView teamCompetition;
        public TextView teamCuota;
        public TextView teamDayTrain;
        public TextView teamStartTrain;
        public TextView teamEndTrain;
        public CheckBox teamActive;
        public TextView teamUser;

        public Button detailsTeamButton;
        //        public Button modifyTeamButton;
        public Button deleteTeamButton;
        public Button matchTeamButton; //Para crear un partido asociado a un equipo

        public View parentView; //vista padre - como el recyclerView

        /**
         * 5) Consturctor del Holder
         */
        public TeamHolder(View view) {
            super(view); //Vista padre
            parentView = view; //Guardamos el componente padre

            teamId = view.findViewById(R.id.team_id);
            teamCategory = view.findViewById(R.id.team_category);
            teamCompetition = view.findViewById(R.id.team_competition);
            teamCuota = view.findViewById(R.id.team_cuota);
            teamDayTrain = view.findViewById(R.id.team_day_train);
            teamStartTrain = view.findViewById(R.id.team_start_train);
            teamEndTrain = view.findViewById(R.id.team_end_train);
            teamActive = view.findViewById(R.id.team_active);
//            teamUser = view.findViewById(R.id.team_user);

//            detailsTeamButton = view.findViewById(R.id.details_team_button);
//            modifyTeamButton = view.findViewById(R.id.modify_team_button); //De momento en está vista no voy a modificar
            deleteTeamButton = view.findViewById(R.id.delete_team_button);
            matchTeamButton = view.findViewById(R.id.match_team_button);

            //TODO añadir opción que realizarán los botones
//            //Para decirle que hace el boton cuando pulsamos sobre el
//            // Ver detalles de un puente
//            detailsBrigdeButton.setOnClickListener(v -> detailsBrigdeButton(getAdapterPosition())); //al pulsar lo llevamos al método detailsBrigdeButton
////            // Modificar un puente
////            modifyBrigdeButton.setOnClickListener(v -> modifyBrigdeButton(getAdapterPosition()));
            // Eliminar un equipo
            deleteTeamButton.setOnClickListener(v -> deleteTeam(getAdapterPosition()));
            //Añadir Partido
            matchTeamButton.setOnClickListener(v -> matchTeamButton(getAdapterPosition()));
        }
    }

    /**
     * Métodos de los botones del layout para recoger el id y registrar una inspection
     */
    private void matchTeamButton(int position) {
        Team team = teamList.get(position);

        Intent intent = new Intent(context, MatchRegisterView.class);
        intent.putExtra("teamId", team.getId());
        context.startActivity(intent);
    }

    private void deleteTeam(int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(R.string.are_you_sure)
                .setTitle(R.string.remove_team)
                .setPositiveButton(R.string.yes, (dialog, id) -> {
                    Team team = teamList.get(position);
                    presenter.deleteTeam(team.getId());

                    teamList.remove(position);
                    notifyItemRemoved(position);
                })
                .setNegativeButton(R.string.no, (dialog, id) -> dialog.dismiss());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
