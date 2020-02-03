package cn.sixlab.minesite.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table
public class MsButton {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer status;

    private Date createTime;

    @Column(length = 30)
    private String btnName;

    @Column(length = 30)
    private String btnIcon;

    @Column(length = 200)
    private String btnIntro;
}
