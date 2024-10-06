package org.scoula.money.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.money.domain.RecentExpenseVO;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecentExpenseDTO {
    private int id;
    private int amount;
    private int categoryId;
    private String description;
    private Date date;

    // VO -> DTO 변환
    public static RecentExpenseDTO of(RecentExpenseVO vo) {
        return vo == null ? null : RecentExpenseDTO.builder()
                .id(vo.getId())
                .amount(vo.getAmount())
                .categoryId(vo.getCategoryId())
                .description(vo.getDescription())
                .date(vo.getDate())
                .build();
    }
}
