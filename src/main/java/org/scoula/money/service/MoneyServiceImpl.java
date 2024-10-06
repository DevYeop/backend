package org.scoula.money.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.scoula.money.domain.CategoryVO;
import org.scoula.money.domain.ExpenseByMonthVO;
import org.scoula.money.domain.ExpenseInsertVO;
import org.scoula.money.domain.RecentExpenseVO;
import org.scoula.money.dto.ExpenseInputDTO;
import org.scoula.money.dto.ExpenseByMonthDTO;
import org.scoula.money.dto.RecentExpenseDTO;
import org.scoula.money.mapper.MoneyMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@RequiredArgsConstructor
public class MoneyServiceImpl implements MoneyService {

    final private MoneyMapper mapper;

    @Override
    public void create(ExpenseInputDTO dto) {
        ExpenseInsertVO expenseVO = dto.toVo();
        log.info(expenseVO);
        mapper.create(expenseVO);
    }

    @Override
    public List<CategoryVO> getCategories() {
        return mapper.getCategories();
    }

    @Override
    public List<ExpenseByMonthDTO> getExpenseByMonth(ExpenseByMonthDTO dto) {
        List<ExpenseByMonthVO> expenseByMonth = mapper.getExpenseByMonth(dto);
        return expenseByMonth.stream().map(ExpenseByMonthDTO::of).toList();
    }

    @Override
    public List<RecentExpenseDTO> getRecentExpense() {
        List<RecentExpenseVO> recentExpense = mapper.getRecentExpense();
        return recentExpense.stream().map(RecentExpenseDTO::of).toList();
    }

}
