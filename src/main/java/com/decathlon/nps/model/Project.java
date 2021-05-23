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
import javax.persistence.OneToMany;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel("Project")
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Project extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -7176390653391227433L;

    @Column(name = "name")
    private String name;

    @Column(name= "total_nps")
    private int totalNps;

}
