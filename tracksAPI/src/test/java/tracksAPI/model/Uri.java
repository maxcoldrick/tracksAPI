
package tracksAPI.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;

public class Uri {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("uri")
    @Expose
    private String uri;

}
