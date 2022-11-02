
package tracksAPI.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;

public class TitleList {

    @SerializedName("primary")
    @Expose
    private String primary;
    @SerializedName("secondary")
    @Expose
    private String secondary;
    @SerializedName("tertiary")
    @Expose
    private Object tertiary;

}
