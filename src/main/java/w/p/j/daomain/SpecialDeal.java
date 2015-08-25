/*
 * Copyright (c) 2015 / 8 / 10 1 :30 :18
 * BY:wupeiji
 * QQ:757671834
 *
 */

package w.p.j.daomain;

import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Date;

/**
 * -------------------------------------
 * Created by wupeji on 2015-08-10 01:30
 * ----------------------------------------
 * 特价活动类
 **/
public class SpecialDeal {
    private Airport departForm;
    private Airport arriveAt;
    private BigDecimal cost;
    private Date beginOn;
    private Date endOn;

    public SpecialDeal(Airport departForm, Airport arriveAt, BigDecimal cost, Date beginOn, Date endOn) {
        this.departForm = departForm;
        this.arriveAt = arriveAt;
        this.cost = cost;
        this.beginOn = new Date(beginOn.getTime());
        this.endOn =new Date(endOn.getTime());
    }

    public Airport getDepartForm() {
        return departForm;
    }


    public Airport getArriveAt() {
        return arriveAt;
    }

    public BigDecimal getCost(){
        return cost;
    }
    public boolean isValidNow(){
        return isValidOn(new Date());
    }

private boolean isValidOn(Date date){
    Assert.notNull(date,"日期不能为空");
    Date dateCopy=new Date(date.getTime());
    return ((dateCopy.equals(beginOn)||dateCopy.after(beginOn))
            &&(dateCopy.equals(endOn)||dateCopy.before(endOn)));
}
}
