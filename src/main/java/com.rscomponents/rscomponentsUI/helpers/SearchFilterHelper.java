package com.rscomponents.rscomponentsUI.helpers;
import com.rscomponents.rscomponentsUI.models.SearchFilter;
import java.util.List;

public class SearchFilterHelper {

    public   SearchFilter createSearchFilterTestData(String[] metadata) {
        String scenario = metadata[0];
        String mainProductType = metadata[1];
        String catagory = metadata[2];
        String subCatagory = metadata[3];
        String filterType1 = metadata[4];
        String filter1 = metadata[5];
        String filterType2 = metadata[6];
        String filter2 = metadata[7];
        return new SearchFilter(scenario, mainProductType, catagory, subCatagory, filterType1, filter1, filterType2, filter2);
    }



    public SearchFilter getTheSearchData(List<SearchFilter> searchFilters, String scenario) {
        SearchFilter result = searchFilters.stream()
                .filter(x -> x.getScenario().equals(scenario))
                .findAny()
                .orElse(null);

        return result;

    }
}

