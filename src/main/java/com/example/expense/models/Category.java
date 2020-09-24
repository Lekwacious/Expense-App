package com.example.expense.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String name;


}
