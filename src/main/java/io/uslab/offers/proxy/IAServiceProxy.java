package io.uslab.offers.proxy;

import model.OfferDetails;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/* First step to check Feign
@FeignClient(name="IA",url="https://ia-grouchy-numbat.cfapps.io")
*/
/**Feign Client Step-2*/
@FeignClient(name="IA")
@RibbonClient(name="IA")
public interface IAServiceProxy {

    @GetMapping("/ia/{pageId}/{placementId}")
    public OfferDetails retriveOfferDetails
            (@PathVariable("pageId") String pageId,@PathVariable("placementId") String placementId);
}
