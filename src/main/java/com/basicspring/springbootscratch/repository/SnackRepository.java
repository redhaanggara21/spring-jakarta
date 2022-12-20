package com.basicspring.springbootscratch.repository;

import com.basicspring.springbootscratch.model.Snack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SnackRepository extends JpaRepository<Snack, Long>{

    SnackRepository findSnackByNameCategory(String name, long id_category);

}
