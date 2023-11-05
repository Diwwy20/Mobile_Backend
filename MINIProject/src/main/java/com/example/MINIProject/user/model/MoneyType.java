package com.example.MINIProject.user.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "MoneyType")
@Table(
		name = "moneytype",
		uniqueConstraints = {
				@UniqueConstraint(name = "moneytype_unique", columnNames = "money_name")
		})
public class MoneyType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAID")
	private Long id;
	
	@Column(name = "money_name", unique = true, nullable = false)
	private String moneyName;
	
	public MoneyType() {}
	
	public MoneyType(String moneyName) {
		super();
		this.moneyName = moneyName;
	}
}
