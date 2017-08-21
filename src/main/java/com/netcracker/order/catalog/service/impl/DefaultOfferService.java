package com.netcracker.order.catalog.service.impl;

import com.netcracker.order.catalog.domain.Category;
import com.netcracker.order.catalog.domain.Offer;
import com.netcracker.order.catalog.domain.Tag;
import com.netcracker.order.catalog.repository.OfferRepository;
import com.netcracker.order.catalog.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ulza1116 on 8/21/2017.
 */
@Service
public class DefaultOfferService implements OfferService {

    private OfferRepository offerRepository;

    @Autowired
    public DefaultOfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void createOffer(Offer offer){
        offerRepository.save(offer);
    }

    @Override
    public List<Offer> findAllOffers(int limit, int startFrom){
        PageRequest pageRequest = new PageRequest(startFrom, limit);
        Page<Offer> offers = offerRepository.findAll(pageRequest);
        return offers.getContent();
    }

    @Override
    public void setTag(Tag tag, int offerId){
        Offer offer1 = offerRepository.findOne(offerId);
        offer1.getTags().add(tag);
        offerRepository.save(offer1);
    }

    @Override
    public void deleteTag(Tag tag, int offerId){
        Offer offer1 = offerRepository.findOne(offerId);
        offer1.getTags().remove(tag);
        offerRepository.save(offer1);
    }

    @Override
    public void changeCategory(Category category, int offerId){
        Offer offer = offerRepository.getOne(offerId);
        offer.setCategory(category);
        offerRepository.save(offer);
    }

    @Override
    public Offer getOffer(int offerId){
        return offerRepository.findOne(offerId);
    }

    @Override
    public void updateOffer(Offer offer, int offerId){
        Offer offer1 = offerRepository.getOne(offerId);
        offer1.setName(offer.getName());
        offer1.setPrice(offer.getPrice());
        offerRepository.save(offer1);
    }

}
