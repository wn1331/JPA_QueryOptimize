package com.example.bigdatas;

import com.example.bigdatas.entity.BigDataParents;
import com.example.bigdatas.entity.BigDatas;
import com.example.bigdatas.repository.BigDataParentsRepository;
import com.example.bigdatas.repository.BigDataRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BigDataTest {

    @Autowired
    private BigDataParentsRepository bigDataParentsRepository;

    @Autowired
    private BigDataRepository bigDataRepository;

//    @Test
//    @DisplayName("10만개 데이터 insert. parent 10개")
//    @Transactional
//    @Rollback(value = false)
//    void insert100kData(){
//        for(int i=1;i<=10;i++){
//            BigDataParents bigDataParents = new BigDataParents(LocalDateTime.now(), LocalDateTime.now().plusHours(i), i + "번째 parents입니다.");
//            bigDataParents = bigDataParentsRepository.save(bigDataParents); // 부모 엔티티를 먼저 저장
//
//            for(int j=1;j<=10000;j++){
//                bigDataRepository.save(new BigDatas(bigDataParents,j,j,j,j,'A',"A",0.1,0.1,0.1,0.1,0.1,0.1));
//
//            }
//        }
//
//    }

//    @Test
//    @Order(1)
//    @DisplayName("normal select")
//    void normalSelect100kDataByParents(){
//        List<BigDataParents> allParents = bigDataParentsRepository.findAll();
//        List<BigDatas> bigDataList = new ArrayList<>();
//        allParents.forEach(parent->{
//            bigDataList.addAll(bigDataRepository.findByBigDataParentsId(parent.getId()));
//        });
//
//        Assertions.assertEquals(bigDataList.size(),100000);
//    }
//
//    @Test
//    @DisplayName("batch select")
//    void batchSelect100kDataByParents(){
//        List<Long> parentIds = bigDataParentsRepository.findAll().stream().map(BigDataParents::getId).toList();
//
//        List<BigDatas> bigDatasList = bigDataRepository.selectAllIn(parentIds);
//
//        Assertions.assertEquals(bigDatasList.size(),100000);
//    }

    @Test
    @DisplayName("normal delete")
    @Transactional
    @Rollback(value = true)
    @Order(0)
    void normalDelete100kData(){
        List<Long> parentIds = bigDataParentsRepository.findAll().stream().map(BigDataParents::getId).toList();
        List<BigDatas> bigDatasList = bigDataRepository.selectAllIn(parentIds);
        bigDataRepository.deleteAll(bigDatasList);

        bigDatasList = bigDataRepository.selectAllIn(parentIds);
        Assertions.assertEquals(bigDatasList.size(),0);
    }

    @Test
    @DisplayName("bulk delete intense")
    @Transactional
    @Rollback(value = true)
    @Order(1)
    void bulkDelete100kDataByParents(){
        List<Long> parentIds = bigDataParentsRepository.findAll().stream().map(BigDataParents::getId).toList();
        bigDataRepository.deleteAllInBatchFromParentIds(parentIds);

        List<BigDatas> bigDatasList = bigDataRepository.selectAllIn(parentIds);
        Assertions.assertEquals(bigDatasList.size(),0);
    }

//    @Test
//    @DisplayName("bulk delete")
//    @Transactional
//    @Rollback(value = true)
//    void bulkDelete100kData(){
//        List<Long> parentIds = bigDataParentsRepository.findAll().stream().map(BigDataParents::getId).toList();
//        List<BigDatas> bigDatasList = bigDataRepository.selectAllIn(parentIds);
//
//        bigDataRepository.deleteAllInBatch(bigDatasList.stream().map(BigDatas::getId).toList());
//
//        bigDatasList = bigDataRepository.selectAllIn(parentIds);
//        Assertions.assertEquals(bigDatasList.size(),0);
//    }



}
