package rocks.theoneapp.laboremus.santecoffee.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import rocks.theoneapp.laboremus.santecoffee.models.Farmer;

@Dao
public interface FarmersDao {

    @Query("SELECT * FROM farmers")
    Flowable<List<Farmer>> getFarmers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable addNewFarmersDatabase(Farmer farmer);

    @Delete
    void deleteFarmer(Farmer farmer);
}
