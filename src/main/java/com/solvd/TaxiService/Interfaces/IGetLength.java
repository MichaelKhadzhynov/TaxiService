package com.solvd.TaxiService.Interfaces;

@FunctionalInterface
public interface IGetLength<T> {

    boolean getLength(T t);
}
