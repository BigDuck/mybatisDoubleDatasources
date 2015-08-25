/*
 * Copyright (c) 2015 / 8 / 10 10 :12 :38
 * BY:wupeiji
 * QQ:757671834
 *
 */

package w.p.j.daomain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * -------------------------------------
 * Created by wupeji on 2015-08-10 10:12
 * ----------------------------------------
 **/
@XmlRootElement
public class People {
    private String name;
    private String address;

    public People() {

    }

    public People(String name, String address) {

        this.name = name;
        this.address = address;
    }
    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
