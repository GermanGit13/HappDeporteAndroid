package com.svalero.happdeporteandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.happdeporteandroid.R;
import com.svalero.happdeporteandroid.domain.Team;
import com.svalero.happdeporteandroid.domain.User;
import com.svalero.happdeporteandroid.view.MatchRegisterView;
import com.svalero.happdeporteandroid.view.TeamRegisterView;

import java.util.List;

/**
 * TeamAdapter: Es la clase en la que le explicamos a Android como pintar cada elemento en el RecyclerView
 * Patron Holder: 1) Constructor - 2) onCreateViewHolder - 3) onBindViewHolder - 4) getItemCount - 5) Y la estructura SuperheroHolder
 * al extender de la clase RecyclerView los @Override los añadira automáticamente para el patron Holder, solo añadiremos nosotros el 5)
 *
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    private Context context; // Activity en la que estamos
    private List<User> userList;
    private User user;

    /**
     * 1) Constructor que creamos para pasarle los datos que queremos que pinte
     * el contexto y la lista de equipos
     * @param dataList Lista de equipos que le pasamos
     */
    public UserAdapter(Context context, List<User> dataList) {
        this.context = context;
        this.userList = dataList;
    }

    /**
     * Metodo con el que Android va a inflar, va a crear cada estructura del layout donde irán los datos de cada equipo.
     * Vista detalle de cada equipo
     */
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false); // el layout user_item para cada usuario
        return new UserHolder(view); //Creamos un holder para cada una de las estructuras que infla el layout
    }

    /**
     * Metodo que estamos obligados para hacer corresponder los valores de la lista y pintarlo en cada elemento de layout
     * es para poder recorrer en el bucle por cada elemento de la lista y poder pintarlo
     */
    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
//        holder.userId.setText(userList.get(position).getId());
        holder.userName.setText(userList.get(position).getName());
        holder.userSurname.setText(userList.get(position).getSurname());
        holder.userAddress.setText(userList.get(position).getAddress());
        holder.userMail.setText(userList.get(position).getMail());
        holder.userPhone.setText(userList.get(position).getPhone());


    }

    /**
     * Metodo que estamos obligados a hacer para que devuelva el número de elementos y android pueda hacer sus calculos y pintar xtodo en base a esos calculos
     */
    @Override
    public int getItemCount() {
        return userList.size(); //devolvemos el tamaño de la lista
    }

    /**
     * 5) Holder son las estructuras que contienen los datos y los rellenan luego
     * Creamos todos los componentes que tenemos
     */
    public class UserHolder extends RecyclerView.ViewHolder {
//        public TextView userId;
        public TextView userName;
        public TextView userSurname;
        public TextView userAddress;
        public TextView userMail;
        public TextView userPhone;
//        public TextView userActive;

        public Button detailsUserButton;
        //        public Button modifyUserButton;
        public Button deleteUserButton;
        public Button teamUserButton; //Para crear un partido asociado a un equipo

        public View parentView; //vista padre - como el recyclerView

        /**
         * 5) Consturctor del Holder
         */
        public UserHolder(View view) {
            super(view); //Vista padre
            parentView = view; //Guardamos el componente padre

//            userId = view.findViewById(R.id.user_id);
            userName = view.findViewById(R.id.user_name);
            userSurname = view.findViewById(R.id.user_surname);
            userAddress = view.findViewById(R.id.user_address);
            userMail = view.findViewById(R.id.user_mail);
            userPhone = view.findViewById(R.id.user_phone);
//            userActive = view.findViewById(R.id.user_active);

            detailsUserButton = view.findViewById(R.id.details_user_button);
//            modifyUserButton = view.findViewById(R.id.modify_user_button); //De momento en está vista no voy a modificar
            deleteUserButton = view.findViewById(R.id.delete_user_button);
            teamUserButton = view.findViewById(R.id.team_user_button);

            //TODO añadir opción que realizarán los botones
//            //Para decirle que hace el boton cuando pulsamos sobre el
//            // Ver detalles de un puente
//            detailsBrigdeButton.setOnClickListener(v -> detailsBrigdeButton(getAdapterPosition())); //al pulsar lo llevamos al método detailsBrigdeButton
////            // Modificar un puente
////            modifyBrigdeButton.setOnClickListener(v -> modifyBrigdeButton(getAdapterPosition()));
//            // Eliminar un puente
//            deleteBrigdeButton.setOnClickListener(v -> deleteBrigdeButton(getAdapterPosition()));
            //Añadir Equipo a entrenador
            teamUserButton.setOnClickListener(v -> userTeamButton(getAdapterPosition()));
        }

        /**
         * Métodos de los botones del layout para recoger el id y registrar una inspection
         */
        private void userTeamButton(int position) {
            User user = userList.get(position);

            Intent intent = new Intent(context, TeamRegisterView.class);
            intent.putExtra("userId", user.getId());
            context.startActivity(intent);

        }
    }
}
