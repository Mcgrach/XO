package com.account.repository;

import com.account.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Created by mcgra on 16.02.2017.
 */
public interface StatisticsRepository extends JpaRepository<Statistics, Long>{
}
