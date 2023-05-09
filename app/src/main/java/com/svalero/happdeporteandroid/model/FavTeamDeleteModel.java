package com.svalero.happdeporteandroid.model;

import static com.svalero.happdeporteandroid.db.Constants.DATABASE_NAME;

import androidx.room.Room;

import com.svalero.happdeporteandroid.contract.FavTeamDeleteContract;
import com.svalero.happdeporteandroid.contract.FavTeamListContract;
import com.svalero.happdeporteandroid.db.AppDatabase;
import com.svalero.happdeporteandroid.domain.FavTeam;

import java.util.List;

//public class FavTeamDeleteModel implements FavTeamDeleteContract.Model {
//
//    @Override
//    public boolean deleteFavTeam(FavTeam favTeam) {
////        final AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, DATABASE_NAME) //Instanciamos la BBDD -> Pasamos el contexto para saber donde estamos
////                .allowMainThreadQueries().build();
////        db.favTeamDao().delete(f);
////    }
//}
