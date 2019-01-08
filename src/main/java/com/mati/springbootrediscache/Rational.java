package com.mati.springbootrediscache;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class Rational implements Serializable {
    private final Integer a,b;
}
