package com.opendatasoft.elasticsearch.plugin.geohashclustering;

import com.opendatasoft.elasticsearch.search.aggregations.bucket.geohashclustering.GeoHashClusteringParser;
import org.elasticsearch.plugins.AbstractPlugin;
import org.elasticsearch.search.aggregations.AggregationModule;
import com.opendatasoft.elasticsearch.search.aggregations.bucket.geohashclustering.InternalGeoHashClustering;

public class GeohashClusteringAggregationsPlugin extends AbstractPlugin {
    @Override
    public String name() {
        return "Geohash Clustering";
    }

    @Override
    public String description() {
        return "Return a bucket with merged clusters";
    }

    public void onModule(AggregationModule aggModule) {
        aggModule.addAggregatorParser(GeoHashClusteringParser.class);
        InternalGeoHashClustering.registerStreams();
    }

}
