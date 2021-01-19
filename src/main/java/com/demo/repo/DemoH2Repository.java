package com.demo.repo;

import com.demo.pojo.DemoEntiry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemoH2Repository extends JpaRepository<DemoEntiry, Long> {

    List<DemoEntiry> findByNameContaining(String name);
}
