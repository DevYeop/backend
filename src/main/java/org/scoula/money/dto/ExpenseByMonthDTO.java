package org.scoula.money.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.money.domain.ExpenseByMonthVO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseByMonthDTO {
    @JsonIgnore
    private int year;
    @JsonIgnore
    private int month;
    private String categoryName;
    private int totalAmount;

    // VO -> DTO 변환
    public static ExpenseByMonthDTO of(ExpenseByMonthVO vo) {
        return vo == null ? null : ExpenseByMonthDTO.builder()
                .categoryName(vo.getName())
                .totalAmount(vo.getTotalAmount())
                .build();
    }
}
