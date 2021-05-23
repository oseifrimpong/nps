package com.decathlon.nps.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ApiModel("Answer")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Answer extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -7176390653391227433L;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "score")
    private int score;

    @ManyToOne(targetEntity = Survey.class, fetch = FetchType.LAZY)
    private Survey survey;
}
