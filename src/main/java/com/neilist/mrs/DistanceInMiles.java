package com.neilist.mrs;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.geotools.referencing.GeodeticCalculator;
import org.geotools.referencing.crs.DefaultGeographicCRS;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
//import org.opengis.referencing.crs.CoordinateReferenceSystem;

public class DistanceInMiles {

    public static void main(String[] args) throws Exception {

        final  double METERS_IN_A_MILES = 1609.34;


        GeometryFactory geometryFactory = new GeometryFactory();
        final Coordinate denverCoordinate  = new Coordinate(-104.997633, 39.751907);
        final Point denverPoint = geometryFactory.createPoint(denverCoordinate );
        final Coordinate boulderCoordinate  = new Coordinate(-105.372324, 40.043465);
        Point boulderPoint = geometryFactory.createPoint(boulderCoordinate);

//        double distance  = denver.distance(boulder);

        // the following code is based on JTS.orthodromicDistance( start, end, crs )
//        GeodeticCalculator gc = new GeodeticCalculator(crs);
//        gc.setStartingPosition( JTS.toDirectPosition( start, crs ) );
//        gc.setDestinationPosition( JTS.toDirectPosition( end, crs ) );


        CoordinateReferenceSystem crs = DefaultGeographicCRS.WGS84;
//        CoordinateReferenceSystem crs = CRS.decode("EPSG:4326");
//        CoordinateReferenceSystem crs = CRS.decode("EPSG:3785");
        GeodeticCalculator geodeticCalculator = new GeodeticCalculator( crs );

//        double distance = geodeticCalculator.getOrthodromicDistance();

        double distance = JTS.orthodromicDistance(denverCoordinate, boulderCoordinate, crs);

        int totalmeters = (int) distance;
        double miles = totalmeters / METERS_IN_A_MILES;
        int km = totalmeters / 1000;
        int meters = totalmeters - (km * 1000);
        float remaining_cm = (float) (distance - totalmeters) * 10000;
        remaining_cm = Math.round(remaining_cm);
        float cm = remaining_cm / 100;

        System.out.println("Distance = " + km + "km " + meters + "m " + cm + "cm " + miles +"miles");

        System.out.println(distance);

    }

}

