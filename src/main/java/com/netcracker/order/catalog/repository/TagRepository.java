package com.netcracker.order.catalog.repository;

import com.netcracker.order.catalog.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ulza1116 on 8/21/2017.
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

}
