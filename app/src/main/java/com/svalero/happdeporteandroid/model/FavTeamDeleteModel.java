package com.svalero.happdeporteandroid.model;

import static com.svalero.happdeporteandroid.db.Constants.DATABASE_NAME;

import android.content.Context;

import androidx.room.Room;

import com.svalero.happdeporteandroid.contract.FavTeamDeleteContract;
import com.svalero.happdeporteandroid.contract.FavTeamListContract;
import com.svalero.happdeporteandroid.db.AppDatabase;
import com.svalero.happdeporteandroid.domain.FavTeam;

import java.util.List;

public class FavTeamDeleteModel implements FavTeamDeleteContract.Model {

    private Context context;

    public FavTeamDeleteModel(Context context) {
        this.context = context;
    }

    @Override
    public boolean deleteFavTeam(FavTeam favTeam) {
        final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME) //Instanciamos la BBDD -> Pasamos el contexto para saber donde estamos
                .allowMainThreadQueries().build();
        db.favTeamDao().delete(favTeam);
        return true;
    }

}
