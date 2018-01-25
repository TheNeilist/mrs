package com.neilist.mrs.service;

import com.neilist.mrs.domain.ZipcodePoint;
import com.neilist.mrs.repository.ZipcodePointRepository;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ZipcodePointService {

    @Autowired
    private ZipcodePointRepository zipcodePointRepository;

    @Autowired
    private GeometryFactory geometryFactory;

    public void importZipcodePoints(File file) {

        long start = System.currentTimeMillis();
        zipcodePointRepository.deleteAll();
        BufferedReader reader = null;
        InputStream inputStream = null;
        try {

            String line;
            inputStream = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(inputStream));

            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(",");
                Point point = geometryFactory.createPoint(new Coordinate(Double.parseDouble(splitLine[2]), Double.parseDouble(splitLine[1])));
                ZipcodePoint zipcodePoint = new ZipcodePoint(splitLine[0], point);
                zipcodePointRepository.save(zipcodePoint);
            }
            System.out.println("completed zip code point import: " + (System.currentTimeMillis() - start));
        } catch (Exception e) {
            System.err.println("caught an exception importing zip code points: ");
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    inputStream.close();
                    reader.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}
