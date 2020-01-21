package cn.sixlab.minesite.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@Data
public class MsMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer status;

    private Date createTime;

    @Column(length = 10)
    private String type;

    @Column(length = 30)
    private String menuCode;

    @Column(length = 30)
    private String menuName;

    @Column(length = 100)
    private String menuPath;

    private Integer menuLevel;

    private Integer parentId;

    private Boolean isLeaf;

    @Column(length = 30)
    private String menuIcon;

    @Column(length = 200)
    private String menuIntro;
}
