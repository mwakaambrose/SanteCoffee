package rocks.theoneapp.laboremus.santecoffee.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rocks.theoneapp.laboremus.santecoffee.models.Farmer;
import rocks.theoneapp.laboremus.santecoffee.network.ApiClient;
import rocks.theoneapp.laboremus.santecoffee.network.ApiService;

public class FarmersRepository {
    private ApiService apiService;

    public FarmersRepository(){
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<List<Farmer>> getFarmersFromServer(){
        MutableLiveData<List<Farmer>> data = new MutableLiveData<>();
        apiService.getFarmers().enqueue(new Callback<List<Farmer>>() {
            @Override
            public void onResponse(Call<List<Farmer>> call, Response<List<Farmer>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Farmer>> call, Throwable t) {
                Log.d("Mwaka", t.getLocalizedMessage());
            }
        });
        return data;
    }
}
