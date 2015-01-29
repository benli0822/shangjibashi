package com.menudesigner.sjbs.service.repository;

import com.menudesigner.sjbs.domain.Dish;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by JIN Benli on 03/11/14.
 */
public interface DishRepository extends PagingAndSortingRepository<Dish, Long> {
    List<Dish> findDishByName(String name);


}

//interface DishTypeRepository extends JpaRepository<Dish, Long> {
//    @Query(value =
//            "SELECT * FROM md_dish d INNER JOIN md_dish_type dt ON dt.dish_id=d.id INNER JOIN md_type t ON dt.type_id=t.id WHERE t.description=?0", nativeQuery = true)
//    Page<Dish> findDishByTypes(String typeDescription, Pageable pageable);
//}
