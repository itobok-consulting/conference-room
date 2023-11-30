package com.mashreq.kcm.conferenceroom.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@TypeDef(name = "jsonb" , typeClass = JsonBinaryType.class)
public class Bookings extends BaseEntity {
    private String startTime;
    private String endTime;
    private String conferenceName;
}
