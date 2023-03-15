package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Model {


        private  Integer id;
        private String name;
        private String surname;
        private ArrayList<InnerClass> list;
        private Integer value_new;


    }

