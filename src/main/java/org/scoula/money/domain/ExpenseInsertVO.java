package org.scoula.money.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseInsertVO {

    private int id;                // 지출 항목의 고유 ID
    private int userId;            // 유저 ID
    private int amount;     // 지출 금액
    private int category;       // 지출 카테고리
    private String description;    // 지출 설명 (옵션)
    private Date date;             // 지출 날짜
    private String paymentMethod;  // 결제 수단 (카드, 현금 등)
    private Timestamp createdAt;   // 생성 일시
    private Timestamp updatedAt;   // 수정 일시
}
