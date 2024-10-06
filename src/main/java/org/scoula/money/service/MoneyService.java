package org.scoula.money.service;

import org.scoula.money.domain.CategoryVO;
import org.scoula.money.dto.ExpenseInputDTO;
import org.scoula.money.dto.ExpenseByMonthDTO;
import org.scoula.money.dto.RecentExpenseDTO;

import java.util.List;

public interface MoneyService {
    void create(ExpenseInputDTO dto);

    List<CategoryVO> getCategories();

    List<ExpenseByMonthDTO> getExpenseByMonth(ExpenseByMonthDTO dto);

    List<RecentExpenseDTO> getRecentExpense();

}
