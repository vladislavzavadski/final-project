package com.netcracker.order.catalog.service.impl;

import com.netcracker.order.catalog.domain.Tag;
import com.netcracker.order.catalog.repository.TagRepository;
import com.netcracker.order.catalog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ulza1116 on 8/21/2017.
 */
@Service
public class DefaultTagService implements TagService {

    private final TagRepository tagRepository;

    @Autowired
    public DefaultTagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public void createTag(Tag tag){
        tagRepository.save(tag);
    }

    @Override
    public Tag getTag(int tagId){
        return tagRepository.getOne(tagId);
    }

    @Override
    public void deleteTag(int tagId){
        tagRepository.delete(tagId);
    }

    @Override
    public void updateTag(Tag tag, int tagId) {
        Tag tag1 = tagRepository.getOne(tagId);
        tag1.setValue(tag.getValue());
        tagRepository.save(tag1);
    }

    @Override
    public void createTag(List<Tag> tagList){
        tagRepository.save(tagList);
    }
}
