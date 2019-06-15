package com.exa.api.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Table
import javax.persistence.GenerationType
import javax.validation.constraints.NotNull
import javax.persistence.Column

@Entity
@Table(name = "categories")
class Category{
    public Category() {}
    
    Category(Integer id) {
        this.id = id
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id

    @NotNull
    @Column(nullable = false)
    String nama
    
    @NotNull
    @Column(nullable = false)
    String jenis

    @NotNull
    @Column()
    String ket
}