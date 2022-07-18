package com.root.customer.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_id_sequence" , sequenceName = "customer_id_sequence")
    @GeneratedValue(generator = "customer_id_sequence" , strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

}
