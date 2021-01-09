package com.cmbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bankaccount")
public class BankAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountid;

	@Column(nullable = false, unique = true, length = 45)
	private String email;

	@Column(nullable = false, length = 64)
	private String accounttype;

	@Column(name = "accountnumber", nullable = false, length = 20)
	private long accountnumber;

	@Column(name = "currentbalance", nullable = true, length = 20)
	private long currentbalance;

	@Column(name = "uuid", nullable = true, length = 20)
	private String uuid;

	@Column(name = "pannumber", nullable = false, length = 100)
	private String pannumber;

	public BankAccount() {
		super();
		accountnumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
	}

	public Long getAccountid() {
		return accountid;
	}

	public void setAccountid(Long accountid) {
		this.accountid = accountid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public long getCurrentbalance() {
		return currentbalance;
	}

	public void setCurrentbalance(long currentbalance) {
		this.currentbalance = currentbalance;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPannumber() {
		return pannumber;
	}

	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}

}
