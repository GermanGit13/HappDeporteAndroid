package com.svalero.happdeporteandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.happdeporteandroid.R;
import com.svalero.happdeporteandroid.domain.Team;

import java.util.List;

/**
 * TeamAdapter: Es la clase en la que le explicamos a Android como pintar cada elemento en el RecyclerView
 * Patron Holder: 1) Constructor - 2) onCreateViewHolder - 3) onBindViewHolder - 4) getItemCount - 5) Y la estructura SuperheroHolder
 * al extender de la clase RecyclerView los @Override los añadira automáticamente para el patron Holder, solo añadiremos nosotros el 5)
 *
 */
public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamHolder> {

    private Context context; // Activity en la que estamos
    private List<Team> teamList;
    private Team team;

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
//        holder.teamId.setText(teamList.get(position).getId());
        holder.teamCategory.setText(teamList.get(position).getCategory());
        holder.teamCompetition.setText(teamList.get(position).getCompetition());
//        holder.teamCuota.setText(teamList.get(position).getCuota());
        holder.teamDayTrain.setText(teamList.get(position).getDayTrain());
//        holder.teamStartTrain.setText(teamList.get(position).getStartTrain());
//        holder.teamEndTrain.setText(teamList.get(position).getEndTrain());
//        holder.teamActive.setText(teamList.get(position).isActive());
//        holder.teamUser.setText(teamList.get(position).getUser());

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
        public TextView teamActive;
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
            teamUser = view.findViewById(R.id.team_user);

            detailsTeamButton = view.findViewById(R.id.details_team_button);
//            modifyTeamButton = view.findViewById(R.id.modify_team_button); //De momento en está vista no voy a modificar
            deleteTeamButton = view.findViewById(R.id.delete_team_button);
            matchTeamButton = view.findViewById(R.id.match_team_button);

            //TODO añadir opción que realizarán los botones
//            //Para decirle que hace el boton cuando pulsamos sobre el
//            // Ver detalles de un puente
//            detailsBrigdeButton.setOnClickListener(v -> detailsBrigdeButton(getAdapterPosition())); //al pulsar lo llevamos al método detailsBrigdeButton
////            // Modificar un puente
////            modifyBrigdeButton.setOnClickListener(v -> modifyBrigdeButton(getAdapterPosition()));
//            // Eliminar un puente
//            deleteBrigdeButton.setOnClickListener(v -> deleteBrigdeButton(getAdapterPosition()));
//            //Añadir Inspeccion
//            inspectionBrigdeButton.setOnClickListener(v -> inspectionBrigdeButton(getAdapterPosition()));
        }
    }
}
