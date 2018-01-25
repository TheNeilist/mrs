package com.neilist.mrs.repository;

import com.neilist.mrs.MrsApplication;
import com.neilist.mrs.domain.ZipcodePoint;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = MrsApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class ZipcodePointRespositoryIntegrationTest {

    @Autowired
    private ZipcodePointRepository zipcodePointRepository;

    @Ignore
    @Test
    public void testZipcodePointRepository() {

        GeometryFactory geometryFactory = new GeometryFactory();
        Point point = geometryFactory.createPoint(new Coordinate(-104.997633, 39.751907));

        ZipcodePoint zipcodePoint = new ZipcodePoint("80202", point);

        zipcodePointRepository.save(zipcodePoint);

    }
}
