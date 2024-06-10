package com.example.bigdatas.repository;

import com.example.bigdatas.entity.BigDatas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BigDataRepository extends JpaRepository<BigDatas, Long> {

    List<BigDatas> findByBigDataParentsId(Long parentId);

    @Modifying
    @Query("SELECT b FROM BigDatas b WHERE b.bigDataParents.id in :parentIds")
    List<BigDatas> selectAllIn(@Param("parentIds") List<Long> parentIds);

    @Modifying
    @Query("DELETE FROM BigDatas b WHERE b.bigDataParents.id in :parentIds")
    void deleteAllInBatchFromParentIds(@Param("parentIds") List<Long> parentIds);

    @Modifying
    @Query("DELETE FROM BigDatas b WHERE b.id in :ids")
    void deleteAllInBatch(@Param("ids") List<Long> ids);
}
