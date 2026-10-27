package com.example.demo.controller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 7주차 연습문제 코드 추가 (오류 처리 한 곳에 모으기)
@RestControllerAdvice // 전역 예외 처리 컨트롤러
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException e) {
        // 등록, 수정, 삭제 시 발생하는 IllegalArgumentException을 일괄적으로 400 에러 처리
        return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
    }
}