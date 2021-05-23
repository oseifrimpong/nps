package com.decathlon.nps.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("Survey")
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Survey extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -7176390653391227433L;

    @Column(name = "project")
    private String project;

    @Column(name = "nps_score")
    private int npsScore;

//    @ManyToOne
//    @JoinColumn(name="id", nullable=false)
//    private Project project;
}
