package com.milton.lseg.broker.entity;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Serializable
public record Symbol(String value) {

}
