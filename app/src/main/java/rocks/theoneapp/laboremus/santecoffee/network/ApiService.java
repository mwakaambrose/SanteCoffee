package rocks.theoneapp.laboremus.santecoffee.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rocks.theoneapp.laboremus.santecoffee.models.Farmer;

public interface ApiService {
    @GET("farmers")
    Call<List<Farmer>> getFarmers();
}
