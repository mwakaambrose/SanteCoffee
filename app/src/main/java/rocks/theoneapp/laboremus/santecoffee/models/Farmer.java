package rocks.theoneapp.laboremus.santecoffee.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "farmers")
public class Farmer implements Serializable {

    @SerializedName("name")
    private String name;

    @SerializedName("gender")
    private String gender;

    @PrimaryKey
    @SerializedName("phone")
    private String phone;


    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
