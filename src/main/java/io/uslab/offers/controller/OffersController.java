package io.uslab.offers.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.uslab.offers.proxy.IAServiceProxy;
import model.OfferDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OffersController {

    @Autowired
    private IAServiceProxy proxy;

    /*
    @GetMapping("/offers")
    @HystrixCommand(fallbackMethod ="backUpIAMethod")
    public OfferDetails retriveOffer(){
        Map<String,String> uriVariables = new HashMap();
        uriVariables.put("pageId","2000");
        uriVariables.put("placementId","WF_CON_HP_PRIMARY_BNR_1");
        ResponseEntity<OfferDetails> responseEntity =
                new RestTemplate().getForEntity("https://ia-grouchy-numbat.cfapps.io/ia/{pageId}/{placementId}",
                OfferDetails.class,
                uriVariables);
        OfferDetails response=responseEntity.getBody();
        return new OfferDetails(response.getPageId(),response.getDescription(),
        response.getPlacementId(),response.getOfferId(),response.getPlacementUrl());

    }*/
    @GetMapping("/offers")
    @HystrixCommand(fallbackMethod ="backUpIAMethod")
    public OfferDetails retriveOffer(){
        OfferDetails response = proxy.retriveOfferDetails("123-43-84","WF_CON_HP_PRIMARY_BNR_1");
        return new OfferDetails(response.getPageId(),response.getDescription(),
                response.getPlacementId(),response.getOfferId(),response.getPlacementUrl());
    }
    public OfferDetails backUpIAMethod(){

        return new OfferDetails("1345","response from backup services",
                "WF_CON_HP_PRIMARY_BNR_1","C_ent_overdraftrewind_hpprimary_web",
                "https://www20.backup.com/assets/images/contextual/banner/student-loans/1200x532/wfic412_ph_g-187715263_1200x532.jpg");
    }
}
