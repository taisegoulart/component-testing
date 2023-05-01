package dev.ifrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/coupon")
public class ComponentTesting {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String calculateCoupon(@FormParam("value") float value, @FormParam("coupon") String coupon){
        if(coupon.equals("CUPOM10")){
            float withDiscount = Math.round(value * 90.0f);
            return String.format("%.0f", withDiscount);
        } else if (coupon.equals("CUPOM15")) {
            float withDiscount = Math.round(value * 85.0f);
            return String.format("%.0f", withDiscount);
        }
        return "fail";
    }
}
