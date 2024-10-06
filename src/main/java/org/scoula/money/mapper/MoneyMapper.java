package org.scoula.money.mapper;

import org.scoula.money.domain.CategoryVO;
import org.scoula.money.domain.ExpenseByMonthVO;
import org.scoula.money.domain.ExpenseInsertVO;
import org.scoula.money.domain.RecentExpenseVO;
import org.scoula.money.dto.ExpenseByMonthDTO;

import java.util.List;

public interface MoneyMapper {
    void create(ExpenseInsertVO board);

    List<CategoryVO> getCategories();

    List<ExpenseByMonthVO> getExpenseByMonth(ExpenseByMonthDTO dto);

    List<RecentExpenseVO> getRecentExpense();
}
