package com.switchfully.eurder.customers.domain;

import java.util.List;

public enum Role {
    MEMBER(List.of(Feature.ORDERING)),
    ADMIN(List.of(Feature.ADD_ITEM, Feature.UPDATE_ITEM, Feature.GET_ALL_CUSTOMERS, Feature.GET_DETAILS_CUSTOMER));

    private final List<Feature> featureList;

    Role(List<Feature> featureList) {
        this.featureList = featureList;
    }

    public boolean containsFeature(Feature feature) {
        return featureList.contains(feature);
    }
}
