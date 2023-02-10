package org.chakkour.buissness;

import org.chakkour.model.BankAccount;
@FunctionalInterface
public interface Condition<T> {
    Boolean test(T o);
}
