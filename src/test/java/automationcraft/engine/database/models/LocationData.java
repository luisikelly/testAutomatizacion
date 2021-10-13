package automationcraft.engine.database.models;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class LocationData {
    @BsonProperty("province")
    private String province;
    @BsonProperty("city")
    private String city;

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public void setCity(@BsonProperty String city) {
        this.city = city;
    }

    public void setProvince(@BsonProperty String province) {
        this.province = province;
    }
}
