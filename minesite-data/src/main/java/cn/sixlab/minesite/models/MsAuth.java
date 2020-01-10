package cn.sixlab.minesite.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@Data
public class MsAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer status;

    private Date createTime;

    @Column(length = 30)
    private String groupName;

    @Column(length = 30)
    private String authCode;

    @Column(length = 30)
    private String authName;

    @Column(length = 200)
    private String authIntro;
}
