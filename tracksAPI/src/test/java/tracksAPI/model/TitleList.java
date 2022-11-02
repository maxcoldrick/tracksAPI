
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

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public String getSecondary() {
        return secondary;
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }

    public Object getTertiary() {
        return tertiary;
    }

    public void setTertiary(Object tertiary) {
        this.tertiary = tertiary;
    }

}
