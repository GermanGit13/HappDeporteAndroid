package com.svalero.happdeporteandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.happdeporteandroid.R;
import com.svalero.happdeporteandroid.domain.FavTeam;
import com.svalero.happdeporteandroid.domain.Team;

import java.util.List;

/**
 * TeamAdapter: Es la clase en la que le explicamos a Android como pintar cada elemento en el RecyclerView
 * Patron Holder: 1) Constructor - 2) onCreateViewHolder - 3) onBindViewHolder - 4) getItemCount - 5) Y la estructura SuperheroHolder
 * al extender de la clase RecyclerView los @Override los añadira automáticamente para el patron Holder, solo añadiremos nosotros el 5)
 * implements TeamDeleteContract.View porque hace las funciones de view para implentar sus metodos
 */
public class FavTeamAdapter extends RecyclerView.Adapter<FavTeamAdapter.TeamHolder> { //implements FavTeamDeleteContract.View {

    private Context context; // Activity en la que estamos
    private List<FavTeam> favTeamList;
    private Team team;
    private View snackBarView;
//    private FavTeamDeletePresenter presenter;


    /**
     * 1) Constructor que creamos para pasarle los datos que queremos que pinte
     * el contexto y la lista de equipos
     * @param dataList Lista de equipos que le pasamos
     */
    public FavTeamAdapter(Context context, List<FavTeam> dataList) {
        this.context = context;
        this.favTeamList = dataList;
//        presenter = new FavTeamDeletePresenter(this);
    }

    public Context getContext() {
        return context;
    }

    /**
     * Metodo con el que Android va a inflar, va a crear cada estructura del layout donde irán los datos de cada equipo.
     * Vista detalle de cada equipo
     */
    @Override
    public TeamHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favteam_item, parent, false); // el layout team_item para cada equipo
        return new TeamHolder(view); //Creamos un holder para cada una de las estructuras que infla el layout
    }

    /**
     * Metodo que estamos obligados para hacer corresponder los valores de la lista y pintarlo en cada elemento de layout
     * es para poder recorrer en el bucle por cada elemento de la lista y poder pintarlo
     */
    @Override
    public void onBindViewHolder(TeamHolder holder, int position) {
//        holder.teamId.setText(String.valueOf(favTeamList.get(position).getId()));
        holder.favTeamCategory.setText(favTeamList.get(position).getCategory());
        holder.favTeamCompetition.setText(favTeamList.get(position).getCompetition());
        holder.favTeamCuota.setText(String.valueOf(favTeamList.get(position).getCuota())); //Proviene de un double
        holder.favTeamDayTrain.setText(favTeamList.get(position).getDayTrain());
        holder.favTeamStartTrain.setText(favTeamList.get(position).getStartTrain());
        holder.favTeamEndTrain.setText(favTeamList.get(position).getEndTrain());
        holder.favTeamActive.setChecked(favTeamList.get(position).isActive()); //Proviene de un boolean acaba en un checkbox
    }

    /**
     * Metodo que estamos obligados a hacer para que devuelva el número de elementos y android pueda hacer sus calculos y pintar xtodo en base a esos calculos
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return favTeamList.size(); //devolvemos el tamaño de la lista
    }

//    //TODO Revisar devolver mensaje
//    @Override
//    public void showError(String errorMessage) {
////        Snackbar.make(((TextView) snackBarView.findViewById(R.id.team_category)), errorMessage,
////                BaseTransientBottomBar.LENGTH_LONG).show();
//    }

//    @Override
//    public void showMessage(String message) {
////        Snackbar.make(((TextView) snackBarView.findViewById(R.id.team_category)), message,
////                BaseTransientBottomBar.LENGTH_LONG).show();
////        Snackbar.make(snackBarView, message,
////                BaseTransientBottomBar.LENGTH_LONG).show();
//    }

    /**
     * 5) Holder son las estructuras que contienen los datos y los rellenan luego
     * Creamos todos los componentes que tenemos
     */
    public class TeamHolder extends RecyclerView.ViewHolder {
//        public TextView teamId;
        public TextView favTeamCategory;
        public TextView favTeamCompetition;
        public TextView favTeamCuota;
        public TextView favTeamDayTrain;
        public TextView favTeamStartTrain;
        public TextView favTeamEndTrain;
        public CheckBox favTeamActive;
        public TextView teamUser;

        public Button deleteFavTeamButton;

        public View parentView; //vista padre - como el recyclerView

        /**
         * 5) Consturctor del Holder
         */
        public TeamHolder(View view) {
            super(view); //Vista padre
            parentView = view; //Guardamos el componente padre

//            teamId = view.findViewById(R.id.team_id);
            favTeamCategory = view.findViewById(R.id.fav_team_category);
            favTeamCompetition = view.findViewById(R.id.fav_team_competition);
            favTeamCuota = view.findViewById(R.id.fav_team_cuota);
            favTeamDayTrain = view.findViewById(R.id.fav_team_day_train);
            favTeamStartTrain = view.findViewById(R.id.fav_team_start_train);
            favTeamEndTrain = view.findViewById(R.id.fav_team_end_train);
            favTeamActive = view.findViewById(R.id.fav_team_active);

            deleteFavTeamButton = view.findViewById(R.id.delete_favteam_button);

            // Eliminar un equipo
//            deleteTeamButton.setOnClickListener(v -> deleteTeam(getAdapterPosition()));

        }
    }

//    private void deleteTeam(int position) {
////        Team team = teamList.get(position);
////        long idTeam = team.getId();
////        Log.d("Team Borrar", "Desde Aviso de Borrar:" + team.getId() + "-" + idTeam);
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        builder.setMessage(R.string.are_you_sure)
//                .setTitle(R.string.remove_team)
//                .setPositiveButton(R.string.yes, (dialog, id) -> {
//                    Team team = teamList.get(position);
//                    presenter.deleteFavTeam(team.getId());
//
//                    teamList.remove(position);
//                    notifyItemRemoved(position);
//                })
//                .setNegativeButton(R.string.no, (dialog, id) -> dialog.dismiss());
//        AlertDialog dialog = builder.create();
//        dialog.show();
//    }

}
