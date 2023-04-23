package com.example.taxi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Node
public class Driver {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String surname;

    private String patronymic;
}
