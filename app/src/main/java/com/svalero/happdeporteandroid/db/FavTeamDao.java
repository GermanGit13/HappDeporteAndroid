package com.svalero.happdeporteandroid.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.svalero.happdeporteandroid.domain.FavTeam;

import java.util.List;
@Dao
public interface FavTeamDao {

    /**
     * Para obtener un lsitado completo
     *
     */
    @Query(value = "SELECT * FROM FavTeam")
    List<FavTeam> getAll();

    /**
     * Para realizar una busqueda por fecha
     */
    @Query(value = "SELECT * FROM FavTeam WHERE category = :category")
    List<FavTeam> getByCategory(String category);

    /**
     * Para realizar una Query de todos los Partidos por id
     */
    @Query(value = "SELECT * FROM FavTeam WHERE id = :id")
    FavTeam getById(long id);

    /**
     * Para insertar en la BBDD
     */
    @Insert
    void insert (FavTeam favTeam);

    /**
     * Para borrar en la BBDD
     */
    @Delete
    void delete(FavTeam favTeam);

    /**
     * Para modificar en la BBDD
     */
    @Update
    void update(FavTeam favTeam);
}
