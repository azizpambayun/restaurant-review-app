package com.project.restaurant.domain.entities;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeRange {

    @Field(type = FieldType.Keyword)
    private String openTime;

    @Field(type = FieldType.Keyword)
    private String closeTime;

}
