package com.svalero.happdeporteandroid.model;

import static com.svalero.happdeporteandroid.db.Constants.DATABASE_NAME;

import android.content.Context;

import androidx.room.Room;

import com.svalero.happdeporteandroid.contract.FavTeamListContract;
import com.svalero.happdeporteandroid.db.AppDatabase;
import com.svalero.happdeporteandroid.domain.FavTeam;

import java.util.List;

public class FavTeamListModel implements FavTeamListContract.Model {

    private Context context;

    public FavTeamListModel(Context context) {
        this.context = context;
    }

    @Override
    public List<FavTeam> loadAllFavTeam() {
        final AppDatabase db = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries().build();
        return db.favTeamDao().getAll();    }
}
