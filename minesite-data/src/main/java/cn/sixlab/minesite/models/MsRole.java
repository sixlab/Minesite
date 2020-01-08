package cn.sixlab.minesite.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@Data
public class MsRole {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 30)
    private String roleName;

    private Integer status;

    private Date createTime;

}
