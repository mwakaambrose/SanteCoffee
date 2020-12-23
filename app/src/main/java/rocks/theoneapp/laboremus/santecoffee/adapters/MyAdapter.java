package rocks.theoneapp.laboremus.santecoffee.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import rocks.theoneapp.laboremus.santecoffee.R;
import rocks.theoneapp.laboremus.santecoffee.models.Farmer;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<Farmer> farmers;

    public MyAdapter(List<Farmer> farmers, Context context) {
        this.farmers = farmers;
        this.context = context;
    }

    @Override
    public int getCount() {
        return farmers.size();
    }

    @Override
    public Farmer getItem(int position) {
        return farmers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.farmer, parent, false);
        }

        TextView name = convertView.findViewById(R.id.farmer_name);
        TextView gender = convertView.findViewById(R.id.farmer_gender);
        TextView phone = convertView.findViewById(R.id.farmer_telehpone);

        name.setText(getItem(position).getName());
        gender.setText(getItem(position).getGender());
        phone.setText(getItem(position).getPhone());

        return convertView;
    }
}
