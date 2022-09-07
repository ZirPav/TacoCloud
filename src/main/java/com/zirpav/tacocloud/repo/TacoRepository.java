package com.zirpav.tacocloud.repo;

import com.zirpav.tacocloud.model.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
