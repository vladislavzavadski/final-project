package com.netcracker.order.catalog.controller;

import com.netcracker.order.catalog.domain.Category;
import com.netcracker.order.catalog.domain.Filter;
import com.netcracker.order.catalog.domain.Offer;
import com.netcracker.order.catalog.domain.Tag;
import com.netcracker.order.catalog.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ulza1116 on 8/21/2017.
 */
@RestController
public class OfferController {

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @RequestMapping(value = "/offer", method = RequestMethod.POST)
    public void createOffer(@RequestBody Offer offer){
        offerService.createOffer(offer);
    }

    @RequestMapping(value = "/offer", method = RequestMethod.GET)
    public List<Offer> getAllOffers(@RequestParam("limit") int limit, @RequestParam("startFrom") int startFrom){
        return offerService.findAllOffers(limit, startFrom);
    }

    @RequestMapping(value = "/offer/{offerId}", method = RequestMethod.PUT)
    public void updateOffer(@RequestBody Offer offer, @PathVariable("offerId") int offerId){
        offerService.updateOffer(offer, offerId);
    }

    @RequestMapping(value = "/offer/{offerId}", method = RequestMethod.GET)
    public Offer getOffer(@PathVariable("offerId") int offerId){
        return offerService.getOffer(offerId);
    }

    @RequestMapping(value = "/offer/tag/{offerId}", method = RequestMethod.PUT)
    public void setTag(@RequestBody Tag tag, @PathVariable("offerId") int offerId){
        offerService.setTag(tag, offerId);
    }

    @RequestMapping(value = "/offer/tag/{offerId}", method = RequestMethod.DELETE)
    public void deleteTag(@RequestBody Tag tag, @PathVariable("offerId") int offerId){
        offerService.deleteTag(tag, offerId);
    }

    @RequestMapping(value = "/offer/category/{offerId}", method = RequestMethod.PUT)
    public void changeCategory(@RequestBody Category category, @PathVariable("offerId") int offerId){
        offerService.changeCategory(category, offerId);
    }

    @RequestMapping(value = "/offer/{offerId}", method = RequestMethod.DELETE)
    public void deleteOffer(@PathVariable("offerId") int offerId){
        offerService.deleteOffer(offerId);
    }

    @RequestMapping(value = "/offer/search", method = RequestMethod.GET)
    public List<Offer> searchOffersByFilter(Filter filter){
        return offerService.searchOffers(filter);
    }

}
