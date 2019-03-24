package com.hotelmanagementsystem.model;

import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Data
@Getter
@Setter
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class User  implements Serializable {
	
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_Sequence")
    @SequenceGenerator(name = "user_Sequence", sequenceName = "USER_SEQ")
    private Long id;
    
    @Column(name = "userId", nullable = false)
    private String userId;
    
    @Column(name = "userFName", nullable = true)
    private String userFName;
    
    @Column(name = "userLName", nullable = true)
    private String userLName;
    
    @Column(name = "userNIC", nullable = true)
    private String userNIC;
    
    @Column(name = "userEmail", nullable = true)
    private String userEmail;
    
    @Column(name = "userType", nullable = true)
    private String userType;
    
    @Column(name = "userImage", nullable = true)
    private String userImage;
    
    @Column(name = "userAddrs", nullable = true)
    private String userAddrs;
    
    @Column(name = "userPassword", nullable = true)
    private String userPassword;
    
    @Column(name = "createdAt", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    
    @Column(name = "statusCode", nullable = false)
    @Value("${some.key:true}")
    private boolean statusCode;
    
}