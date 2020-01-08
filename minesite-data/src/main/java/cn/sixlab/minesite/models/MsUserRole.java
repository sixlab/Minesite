package cn.sixlab.minesite.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@Data
public class MsUserRole {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer roleId;

    private Integer userId;

    private Integer status;

    private Date createTime;
}
