package com.menudesigner.sjbs.service.repository;

import com.menudesigner.sjbs.domain.Dish;
import com.menudesigner.sjbs.domain.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by JIN Benli on 31/01/15.
 */
@Repository
public class DishCustomRepositoryImpl implements DishCustomRepository {

  private final DishRepository dishRepository;

  private final TypeRepository typeRepository;

  @Autowired
  public DishCustomRepositoryImpl(DishRepository dishRepository, TypeRepository typeRepository) {
    this.dishRepository = dishRepository;
    this.typeRepository = typeRepository;
  }

  @Override
  public Page<Dish> findDishByTypesDescription(String description, Pageable pageable) {

    List<Type> typeList = typeRepository.findTypeByDescription(description);

    List<Dish> dishList = (List<Dish>) dishRepository.findAll();

    List<Dish> dishSelected = new ArrayList<>();

    for (Type t : typeList) {
      dishSelected.addAll(dishList.stream().filter(d -> d.getTypes().contains(t)).collect(Collectors.toList()));
    }

    return new PageImpl<>(dishList);
  }
}
