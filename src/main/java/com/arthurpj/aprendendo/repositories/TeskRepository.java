package com.arthurpj.aprendendo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arthurpj.aprendendo.models.tesk;


@Repository
public interface TeskRepository extends JpaRepository<tesk, Long>{
  
 List<tesk> findByUser_Id(long id);
  


}
