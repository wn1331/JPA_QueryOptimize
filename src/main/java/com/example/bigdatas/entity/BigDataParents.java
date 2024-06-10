package com.example.bigdatas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BigDataParents {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    // 데이터 수집 시작 시간
    private LocalDateTime startTime;

    // 데이터 수집 종료 시간
    private LocalDateTime endTime;

    // 데이터 수집 상세
    private String description;

    // 데이터 삭제 시간
    private LocalDateTime deletedAt;

    public void delete(){
        this.deletedAt=LocalDateTime.now();
    }

    public BigDataParents(LocalDateTime startTime, LocalDateTime endTime, String description) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }
}
