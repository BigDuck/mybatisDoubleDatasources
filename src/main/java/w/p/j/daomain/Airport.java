/*
 * Copyright (c) 2015 / 8 / 10 1 :29 :38
 * BY:wupeiji
 * QQ:757671834
 *
 */

package w.p.j.daomain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * -------------------------------------
 * Created by wupeji on 2015-08-10 01:28
 * ----------------------------------------
 **/
@XmlRootElement
public class Airport {
    private String name;
    private String airportCode;
    private List<People> people;

    public Airport(String name, String airportCode, List<People> people) {
        this.name = name;
        this.airportCode = airportCode;
        this.people = people;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", airportCode='" + airportCode + '\'' +
                '}';
    }

   @XmlElement

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    public Airport() {

    }
}
