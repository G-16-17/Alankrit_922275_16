package com.cognizant.ormlearn.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "st_id")
	private int stockId;
	@Column(name = "st_code")
	private String stockCode;
	@Column(name = "st_date")
	private Date stockDate;
	@Column(name = "st_open")
	private BigDecimal stockOpen;
	@Column(name = "st_close")
	private BigDecimal stockClose;
	@Column(name = "st_volume")
	private BigDecimal volume;
	
	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public Date getStockDate() {
		return stockDate;
	}

	public void setStockDate(Date stockDate) {
		this.stockDate = stockDate;
	}

	public BigDecimal getStockOpen() {
		return stockOpen;
	}

	public void setStockOpen(BigDecimal stockOpen) {
		this.stockOpen = stockOpen;
	}

	public BigDecimal getStockClose() {
		return stockClose;
	}

	public void setStockClose(BigDecimal stockClose) {
		this.stockClose = stockClose;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	
	public Stock(int stockId, String stockCode, Date stockDate, BigDecimal stockOpen, BigDecimal stockClose, BigDecimal volume) {
		super();
		this.stockId = stockId;
		this.stockCode = stockCode;
		this.stockDate = stockDate;
		this.stockOpen = stockOpen;
		this.stockClose = stockClose;
		this.volume = volume;
	}

	@Override
	public String toString() {
		return String.format("%-10s%-10s%-20s%-15s%-15s%-15s", stockId,stockCode,stockDate,stockOpen,stockClose,volume);
	}
	
}
