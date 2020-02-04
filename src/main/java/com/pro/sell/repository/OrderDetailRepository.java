package com.pro.sell.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Administrator
 */
public interface OrderDetailRepository extends JpaRepository<com.pro.sell.model.OrderDetailModel, Long>, JpaSpecificationExecutor<com.pro.sell.model.OrderDetailModel> {
//
//    @Query(value = "select ID id, AREA_NO areaNo, AREA_NAME areaName from AREA    ", nativeQuery = true)
//    List<Map> findDataList();
//
//    @Modifying
//    @Query(value = "update AreaModel m set m.ruleParam = :ruleParam ,m.updateTime = :time where m.id = :id ")
//    int updateAreaRuleParam(@Param("id") Long id, @Param("ruleParam") String ruleParam, @Param("time") Date time);
//
//    AreaModel getById(Long id);
//
//    List<AreaModel> findAllByStadiumId(Long stadiumId);
//
//    List<AreaModel> findAllByIdIsIn(List<Long> areaIds);
}
