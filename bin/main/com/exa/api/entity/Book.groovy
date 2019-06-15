package com.exa.api.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Table
import javax.persistence.GenerationType
import javax.validation.constraints.NotNull
import javax.persistence.Column
import javax.persistence.ManyToOne
import javax.persistence.JoinColumn

@Entity
@Table(name = "books")
class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id

    @NotNull
    @Column(nullable = false)
    String book_name
    
    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id", nullable = true)
    Category category

    @NotNull
    @Column()
    String ket
}