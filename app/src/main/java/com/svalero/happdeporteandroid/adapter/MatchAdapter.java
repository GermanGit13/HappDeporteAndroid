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
import com.svalero.happdeporteandroid.domain.Match;
import com.svalero.happdeporteandroid.domain.User;

import java.util.List;

/**
 * MatchAdapter: Es la clase en la que le explicamos a Android como pintar cada elemento en el RecyclerView
 * Patron Holder: 1) Constructor - 2) onCreateViewHolder - 3) onBindViewHolder - 4) getItemCount - 5) Y la estructura SuperheroHolder
 * al extender de la clase RecyclerView los @Override los añadira automáticamente para el patron Holder, solo añadiremos nosotros el 5)
 *
 */
public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchHolder> {

    private Context context; // Activity en la que estamos
    private List<Match> matchList;
    private Match match;

    /**
     * 1) Constructor que creamos para pasarle los datos que queremos que pinte
     * el contexto y la lista de equipos
     * @param dataList Lista de partidos que le pasamos
     */
    public MatchAdapter(Context context, List<Match> dataList) {
        this.context = context;
        this.matchList = dataList;
    }

    /**
     * Metodo con el que Android va a inflar, va a crear cada estructura del layout donde irán los datos de cada partido.
     * Vista detalle de cada partido
     */
    @Override
    public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.match_item, parent, false); // el layout match_item para cada partido
        return new MatchHolder(view); //Creamos un holder para cada una de las estructuras que infla el layout
    }

    /**
     * Metodo que estamos obligados para hacer corresponder los valores de la lista y pintarlo en cada elemento de layout
     * es para poder recorrer en el bucle por cada elemento de la lista y poder pintarlo
     */
    @Override
    public void onBindViewHolder(MatchHolder holder, int position) {
//        holder.userId.setText(userList.get(position).getId());
        holder.teamB.setText(matchList.get(position).getTeamB());
        holder.markerA.setText(String.valueOf(matchList.get(position).getMarkerA())); //Proviene de un Int
        holder.markerB.setText(String.valueOf(matchList.get(position).getMarkerB())); //Proviene de un Int
        holder.analysis.setText(matchList.get(position).getAnalysis());
        holder.dateMatch.setText(matchList.get(position).getDateMatch());
        holder.hourMatch.setText(matchList.get(position).getHourMatch());
    }

    /**
     * Metodo que estamos obligados a hacer para que devuelva el número de elementos y android pueda hacer sus calculos y pintar xtodo en base a esos calculos
     */
    @Override
    public int getItemCount() {
        return matchList.size(); //devolvemos el tamaño de la lista
    }

    /**
     * 5) Holder son las estructuras que contienen los datos y los rellenan luego
     * Creamos todos los componentes que tenemos
     */
    public class MatchHolder extends RecyclerView.ViewHolder {
//        public TextView userId;
        public TextView teamB;
        public TextView markerA;
        public TextView markerB;
        public TextView analysis;
        public TextView dateMatch;
        public TextView hourMatch;

        public Button detailsMatchButton;
        //        public Button modifyUserButton;
        public Button deleteMatchButton;
//        public Button team_user_button; //Para crear un partido asociado a un equipo

        public View parentView; //vista padre - como el recyclerView

        /**
         * 5) Consturctor del Holder
         */
        public MatchHolder(View view) {
            super(view); //Vista padre
            parentView = view; //Guardamos el componente padre

//            userId = view.findViewById(R.id.user_id);
            teamB = view.findViewById(R.id.match_team_b);
            markerA = view.findViewById(R.id.match_markerA);
            markerB = view.findViewById(R.id.match_markerB);
            analysis = view.findViewById(R.id.match_analysis);
            dateMatch = view.findViewById(R.id.match_dateMatch);
            hourMatch = view.findViewById(R.id.match_hourMatch);

//            detailsMatchButton = view.findViewById(R.id.details_match_button);
//            modifyUserButton = view.findViewById(R.id.modify_user_button); //De momento en está vista no voy a modificar
            deleteMatchButton = view.findViewById(R.id.delete_match_button);


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
