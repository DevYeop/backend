package org.scoula.money.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecentExpenseVO {
    private int id;
    private int amount;
    private int categoryId;
    private String description;
    private Date date;
}
