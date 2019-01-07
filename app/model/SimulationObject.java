package model;

import org.jongo.marshall.jackson.oid.MongoObjectId;

public class SimulationObject {

    @MongoObjectId
    private String _id;

    private String statistics;

    public String getInformationFormat() {
        return statistics;
    }

    public void setInformationFormat(String statistics) {
        this.statistics = statistics;
    }
}
