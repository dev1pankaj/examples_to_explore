package com.pluralsight.repository;

import org.springframework.data.repository.CrudRepository;

import com.pluralsight.entity.Epic;

public interface EpicRepository extends CrudRepository<Epic, Long> {

}
