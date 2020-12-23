package rocks.theoneapp.laboremus.santecoffee.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import io.reactivex.Flowable;
import rocks.theoneapp.laboremus.santecoffee.database.SanteCoffeeDatabase;
import rocks.theoneapp.laboremus.santecoffee.models.Farmer;
import rocks.theoneapp.laboremus.santecoffee.repositories.FarmersRepository;


// TODO MA - 21-12-2020
// Check if there is connection then attempt to load from server
// if not then load cached farmers from sql-lite db.
// then update later. Strategy to be decided by business.
// Offline first or network first then go offline
// return farmersRepository.getFarmersFromLocalStorage();

public class FarmersViewModel extends AndroidViewModel {

    private FarmersRepository farmersRepository;
    private SanteCoffeeDatabase santeCoffeeDatabase;

    public FarmersViewModel(Application application){
        super(application);
        farmersRepository = new FarmersRepository();
        santeCoffeeDatabase = SanteCoffeeDatabase.getSanteCoffeeDatabase(application);
    }

    public LiveData<List<Farmer>> getFarmers(){
        return farmersRepository.getFarmersFromServer();
    }

    public Flowable<List<Farmer>> getCacheFarmers(){
        return santeCoffeeDatabase.getFarmersDao().getFarmers();
    }
}
