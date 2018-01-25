package com.neilist.mrs.domain;

import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "zipcode_point")
public class ZipcodePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "zipcode")
    private String zipcode;
    @NotNull
    @Column(name = "point", nullable = false, columnDefinition = "Point")
    private Point point;

    public ZipcodePoint() {
    }

    public ZipcodePoint(String zipcode, Point point) {
        this.zipcode = zipcode;
        this.point = point;
    }

    public ZipcodePoint(Long id, String zipcode, Point point) {
        this.id = id;
        this.zipcode = zipcode;
        this.point = point;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
