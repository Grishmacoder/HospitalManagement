package com.testproject.hospitalManagement.dto;

import com.testproject.hospitalManagement.entity.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class BloodGroupCntResponseEntity {
    private BloodGroupType bloodGroupType;
    private long count;

}
