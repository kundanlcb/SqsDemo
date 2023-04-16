package com.cm.assignment.dto;

import java.io.Serializable;

public class GenericResponse implements Serializable {
    public String msg;
    public int statusCode;
    public Object payload;
}
