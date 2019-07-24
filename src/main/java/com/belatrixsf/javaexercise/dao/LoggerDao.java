package com.belatrixsf.javaexercise.dao;

import com.belatrixsf.javaexercise.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerDao extends JpaRepository<Logger, Long> {

}
