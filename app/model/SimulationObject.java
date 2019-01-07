package model;

import org.jongo.marshall.jackson.oid.MongoObjectId;

public class SimulationObject {

    @MongoObjectId
    private String _id;

    private String informationFormat;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getInformationFormat() {
        return informationFormat;
    }

    public void setInformationFormat(String informationFormat) {
        this.informationFormat = informationFormat;
    }
}
