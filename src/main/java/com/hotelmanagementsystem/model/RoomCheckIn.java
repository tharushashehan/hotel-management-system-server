package com.hotelmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Data
@Getter
@Setter
@Table(name = "room_check_in")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class RoomCheckIn implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "room_check_in_Sequence")
	@SequenceGenerator(name = "room_check_in_Sequence", sequenceName = "ROOM_CHECK_IN_SEQ")
	private Long id;
	
	@ManyToOne
	private RoomDetails roomDetails;

	@Column(name = "startDate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Column(name = "endDate", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	@Column(name = "remark", nullable = true)
	private String remark;

	@JsonIgnore
	@Column(name = "createdAt", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@JsonIgnore
	@Column(name = "updatedAt", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;

	@JsonIgnore
	@Column(name = "statusCode", nullable = false)
	@Value("${some.key:true}")
	private boolean statusCode;
}