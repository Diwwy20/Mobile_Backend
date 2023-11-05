package com.example.MINIProject.user.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "Revenue")
@Table(
		name = "revenue"
		)

public class Revenue {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RID")
	private Long id;
	
	@Column(name = "r_name", nullable = false)
	private String rName;
	
	@Column(name = "r_money", nullable = false)
	private int rMoney;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CAID", referencedColumnName = "CAID", nullable = false)
	@Fetch(FetchMode.JOIN)
	private MoneyType moneyType;
	
	@CreationTimestamp
	@Column(name = "created_at",nullable = false,
	updatable = false, insertable = false,
	columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UID", referencedColumnName = "UID", nullable = false)
	@Fetch(FetchMode.JOIN)
	private User user;
	
	public Revenue() {}
	
	public Revenue(String rName, int rMoney, MoneyType moneyType, User user) {
		super();
		this.rName = rName;
		this.rMoney = rMoney;
		this.moneyType = moneyType;
		this.user = user;
	}
}
