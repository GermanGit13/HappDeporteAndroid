package com.svalero.happdeporteandroid.model;

import static com.svalero.happdeporteandroid.db.Constants.DATABASE_NAME;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;

import androidx.room.Room;

import com.svalero.happdeporteandroid.contract.FavTeamRegisterContract;
import com.svalero.happdeporteandroid.db.AppDatabase;
import com.svalero.happdeporteandroid.domain.FavTeam;

public class FavTeamRegisterModel implements FavTeamRegisterContract.Model {

    private Context context;

    /**
     * Pasamo el contexto desde el presenter
     * @param context
     */
    public FavTeamRegisterModel(Context context) {
        this.context = context;
    }

    @Override
    public boolean registerFavTeam(FavTeam favTeam) {
        try {
            final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries().build();
            db.favTeamDao().insert(favTeam); //insertamos en la BBDD
            return true;
        } catch (SQLiteConstraintException sce) {
            sce.printStackTrace();
            return false;
        }
    }
}
