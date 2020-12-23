package rocks.theoneapp.laboremus.santecoffee.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import rocks.theoneapp.laboremus.santecoffee.R;
import rocks.theoneapp.laboremus.santecoffee.adapters.MyAdapter;
import rocks.theoneapp.laboremus.santecoffee.models.Farmer;
import rocks.theoneapp.laboremus.santecoffee.viewmodels.FarmersViewModel;

public class MainActivity extends AppCompatActivity {

    private FarmersViewModel farmersViewModel;

    private List<Farmer> farmerList;
    private TextView setIsLoading;

    public ListView listView;
    public MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doInitialization();
    }

    private void doInitialization(){
        farmerList = new ArrayList<>();

        setIsLoading = findViewById(R.id.loadingText);

        listView = findViewById(R.id.list_view);
        farmersViewModel = new ViewModelProvider(this).get(FarmersViewModel.class);

        loadFarmers();
    }

    private void loadFarmers() {
        setIsLoading.setVisibility(View.VISIBLE);

        farmersViewModel.getFarmers().observe(this, (@NonNull List<Farmer> farmers) -> {
            if (farmers != null){
                farmerList.addAll(farmers);
                updateUi();
            } else if (farmers.size() < 0) {
                Toast.makeText(this, "The List is Empty ... ", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, farmers.size() + "Something went wrong. Service Unavailable!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void updateUi(){
        adapter = new MyAdapter(farmerList, getApplicationContext());
        listView.setAdapter(adapter);

        setIsLoading.setVisibility(View.GONE);
    }
}