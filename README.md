Elasticsearch Aggregation Geoclustering Plugin
================================================


The geoclutering aggregation plugin adds the possibility to aggregate Geo Points in geographical clusters.


|   Geoclustering aggregation Plugin  | elasticsearch     | Release date |
|-------------------------------------|-------------------|:------------:|
| 1.0.0                               | 1.2.2 -> master   |  2014-07-16  |


Usage
-----

```json
{
  "aggregations": {
    "<aggregation_name>": {
      "geohash_clustering": {
        "field": "<field_name>",
        "zoom": "<zoom>"
      }
    }
  }
}
```

`field` must be of type geo_point.
`zoom` is a mandatory integer parameter between 0 and 20. It represents the zoom level used in the request to aggregate geo points.
The plugin aggregates these points in geohash with a "good" precision depending on the zoom provided. Then it merges clusters based on distance (in pixels).
Default distance is set to 100, but can be set to another integer in the request.

For example :

```json
{
    "aggregations" : {
        "my_cluster_aggregation" : {
            "geohash_clustering": {
                "field": "geo_point",
                "zoom": 0,
                "distance": 50
            }
        }
    }
}
```

```json
{
    "aggregations": {
         "my_cluster_aggregation": {
            "buckets": [
               {
                  "key": "u0",
                  "doc_count": 90293,
                  "geohash_grids": [
                     [
                        "u0"
                     ]
                  ],
                  "cluster_center": {
                     "type": "point",
                     "coordinates": [
                        2.32920361762,
                        48.8449899502
                     ]
                  }
               }
            ]
         }
    }

}
```

Installation
------------

bin/plugin --install geo_clustering --url "https://github.com/opendatasoft/elasticsearch-aggregation-geoclustering/raw/master/dist/geohash_clustering-1.0.0.zip"


License
-------

This software is under The MIT License (MIT)
