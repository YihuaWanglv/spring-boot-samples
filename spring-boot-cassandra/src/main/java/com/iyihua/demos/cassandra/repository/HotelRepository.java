package com.iyihua.demos.cassandra.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.iyihua.demos.cassandra.domain.Hotel;
 
public interface HotelRepository extends CrudRepository<Hotel, UUID>{}
