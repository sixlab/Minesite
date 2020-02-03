package cn.sixlab.minesite.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(
        indexes = {
                @Index(columnList = "type"),
                @Index(columnList = "roleId"),
                @Index(columnList = "resourceId")
        }
)
public class MsAuthResource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer status;

    private Date createTime;

    // menu   菜单
    // button 按钮
    @Column(length = 10)
    private String type;

    private Integer roleId;

    private Integer resourceId;
}
