package org.scoula.money.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.money.domain.ExpenseInsertVO;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseInputDTO {
    private int id;                // 지출 항목의 고유 ID
    private int userId;            // 유저 ID
    private int amount;     // 지출 금액
    private int categoryId;       // 지출 카테고리
    private String description;    // 지출 설명 (옵션)
    private Date date;             // 지출 날짜
    private String paymentMethod;  // 결제 수단 (카드, 현금 등)
    private Timestamp createdAt;   // 생성 일시
    private Timestamp updatedAt;   // 수정 일시

    // VO -> DTO 변환
    public static ExpenseInputDTO of(ExpenseInsertVO vo) {
        return vo == null ? null : ExpenseInputDTO.builder()
                .id(vo.getId())
                .userId(vo.getUserId())
                .amount(vo.getAmount())
                .categoryId(vo.getCategory())
                .description(vo.getDescription())
                .date(vo.getDate())
                .paymentMethod(vo.getPaymentMethod())
                .createdAt(vo.getCreatedAt())
                .updatedAt(vo.getUpdatedAt())
                .build();
    }

    // DTO -> VO 변환
    public ExpenseInsertVO toVo() {
        return ExpenseInsertVO.builder()
                .id(id)
                .userId(userId)
                .amount(amount)
                .category(categoryId)
                .description(description)
                .date(date)
                .paymentMethod(paymentMethod)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
