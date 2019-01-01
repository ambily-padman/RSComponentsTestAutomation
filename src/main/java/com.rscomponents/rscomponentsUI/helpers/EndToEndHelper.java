package com.rscomponents.rscomponentsUI.helpers;

import com.rscomponents.rscomponentsUI.models.EndToEnd;

import java.util.List;

public class EndToEndHelper {

    public   EndToEnd createEndToEndTestData(String[] metadata) {
        String Scenario = metadata[0];
        String ProductType = metadata[1];
        String Brand = metadata[2];
        String Catagory = metadata[3];
        String SubCatagory = metadata[4];
        String Item = metadata[5];
        return new EndToEnd(Scenario,ProductType,Brand,Catagory,SubCatagory,Item);
    }

    public EndToEnd getTheEndToEndTestData(List<EndToEnd> endToEnds, String scenario) {
        EndToEnd result = endToEnds.stream()
                .filter(x -> x.getScenario().equals(scenario))
                .findAny()
                .orElse(null);

        return result;

    }

}
