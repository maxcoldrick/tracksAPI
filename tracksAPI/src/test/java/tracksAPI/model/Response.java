package tracksAPI.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    @SerializedName("data")
    @Expose
    public List<Data> data = null;

}

