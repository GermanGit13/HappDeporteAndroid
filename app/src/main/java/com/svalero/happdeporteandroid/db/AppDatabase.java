package com.svalero.happdeporteandroid.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.svalero.happdeporteandroid.domain.FavTeam;

@Database(entities = {FavTeam.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FavTeamDao favTeamDao();
}
