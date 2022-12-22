package com.solvd.TaxiService.Interfaces;

@FunctionalInterface
public interface IGetMaxSpeed<M>{

    boolean getMaxSpeed(M m);
}
