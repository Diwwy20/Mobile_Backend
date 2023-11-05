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
@Entity(name = "Expenses")
@Table(
		name = "expenses")

public class Expenses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EID")
	private Long id;
	
	@Column(name = "e_name", nullable = false)
	private String eName;
	
	@Column(name = "e_money", nullable = false)
	private int eMoney;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CAID", referencedColumnName = "CAID", nullable = false)
	@Fetch(FetchMode.JOIN)
	private MoneyType moneyType;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "CID", referencedColumnName = "CID", nullable = false)
//	@Fetch(FetchMode.JOIN)
//	private Categories categories;
	
	@CreationTimestamp
	@Column(name = "created_at",nullable = false,
	updatable = false, insertable = false,
	columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UID", referencedColumnName = "UID", nullable = false)
	@Fetch(FetchMode.JOIN)
	private User user;
	
	public Expenses() {}
	
	public Expenses(String eName, int eMoney, MoneyType moneyType, User user) {
		super();
		this.eName = eName;
		this.eMoney = eMoney;
		this.moneyType = moneyType;
		this.user = user;
	}
}
