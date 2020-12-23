package rocks.theoneapp.laboremus.santecoffee.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import rocks.theoneapp.laboremus.santecoffee.dao.FarmersDao;
import rocks.theoneapp.laboremus.santecoffee.models.Farmer;

@Database(entities = Farmer.class, version = 1, exportSchema = false)
public abstract class SanteCoffeeDatabase extends RoomDatabase {
    private static SanteCoffeeDatabase santeCoffeeDatabase;

    public static synchronized SanteCoffeeDatabase getSanteCoffeeDatabase(Context context){
        if (santeCoffeeDatabase == null){
            santeCoffeeDatabase = Room.databaseBuilder(context, SanteCoffeeDatabase.class, "sante_coffee_database").build();
        }
        return santeCoffeeDatabase;
    }

    public abstract FarmersDao getFarmersDao();
}
