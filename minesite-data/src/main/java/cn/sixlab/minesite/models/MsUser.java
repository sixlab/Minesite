package cn.sixlab.minesite.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@Data
public class MsUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    private String username;

    @Column(length = 100)
    private String password;

    private Integer status;

    private Date createTime;
}
