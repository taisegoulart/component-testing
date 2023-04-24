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
    public String calculateCoupon(@FormParam("value") float valor, @FormParam("coupon") String coupon) {
        return "103521";
       //TODO implementar o método
       //TODO: praticar test-driven-development! --> ver fotos: situações de erro, de número negativo...
    }
}