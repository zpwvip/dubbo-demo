package com.dubbo.entity;

import com.dubbo.entity.converter.EnableDisableStatusConverter;
import com.dubbo.entity.converter.GenderConverter;
import com.dubbo.entity.converter.YesNoStatusConverter;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lkp on 14-6-12.
 * 用户信息表
 */
@Entity
@Table(name = "p_user")
@DynamicInsert
@DynamicUpdate
@Getter@Setter
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String openId;
    private String pcOpenId;
    //自定义用户名，格式是openId + "@" + idCard
    @Column(unique = true)
    private String username;
    //用户姓名
    private String name;
    //身份证号
    private String idCard;
    //出生日期
    private String birthday;
    //性别
    @Column(nullable = false)
    @Convert(converter = GenderConverter.class)
    private Gender gender;
    //手机号
    private String mobile;
    //是否是默认用户
    @Column(nullable = false)
    @Convert(converter = YesNoStatusConverter.class)
    private YesNoStatus isDefault;
    //是否是有效用户
    @Column(nullable = false)
    @Convert(converter = EnableDisableStatusConverter.class)
    private EnableDisableStatus valid;
    //创建时间
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdTime;
    @Transient
    private String createTime;
    //更新时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;
    //就诊卡号（不存库）
    @Transient
    private String cardNo;
    //用户头像
    private String headUrl;
    // 详细地址
    private String detailedAddress;
    // 用户地址
    private String address;
    // 关系
    private String relationship;
    // 类型
    private String type;

    //密码
    private String password;

    //智慧社区ID
    private String communityId;

    //智慧社区名称
    private String communityName;

    //智慧社区用户ID
    private String communityUserId;

    //儿童姓名
    private String childrenName;

    //儿童性别
    private String childrenGender;

    //儿童出生日期
    private String childrenBirthday;

    //儿童身份证号
    private String childrenIdCard;

    //我的订单
//    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL, mappedBy="user")
//    private Set<BookingOrder> bookingOrderList;
}
