package com.solvd.TaxiService.exception;

public class IncorrectChoiceException extends IllegalArgumentException{
    public IncorrectChoiceException(String massage){
        super(massage);

    }
}
