package com.yetiantian.campus_erp.domain;

import jakarta.persistence.*;
        import java.math.BigDecimal;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Project(String name, BigDecimal totalAmount) {
        this.name = name;
        this.totalAmount = totalAmount;
    }

    // getter / setter（同样用 Alt + Insert 生成）
}