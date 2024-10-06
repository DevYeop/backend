package org.scoula.money.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.money.dto.ExpenseInputDTO;
import org.scoula.money.dto.ExpenseByMonthDTO;
import org.scoula.money.service.MoneyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/money")
@RequiredArgsConstructor
@Slf4j
public class MoneyController {
    private final MoneyService service;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody ExpenseInputDTO dto) {
        log.info(String.valueOf(dto));
        service.create(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getCategory() {
        return ResponseEntity.ok(service.getCategories());
    }

    @GetMapping("/expenseByMonth")
    public ResponseEntity<?> getExpenseByMonth(ExpenseByMonthDTO dto) {
        return ResponseEntity.ok(service.getExpenseByMonth(dto));
    }

    @GetMapping("/recentExpense")
    public ResponseEntity<?> getRecentExpense() {
        return ResponseEntity.ok(service.getRecentExpense());
    }


}