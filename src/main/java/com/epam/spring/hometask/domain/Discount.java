package com.epam.spring.hometask.domain;

import javax.persistence.*;

@Entity
@Table(name = "DISCOUNTS")
@AttributeOverride(name = "id", column = @Column(name = "EVENTID"))
public class Discount extends DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DISCOUNTID")
    private Long id;

    @Column(name = "VALUE")
    private int discountValue;

    @Column(name = "NAME")
    private String discountName;

    public Discount() {
    }

    public Discount(int discountValue, String discountName) {
        this.discountValue = discountValue;
        this.discountName = discountName;
    }

    public void setDiscountValue(int discountValue) {
        this.discountValue = discountValue;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public int getDiscountValue() {
        return discountValue;
    }

    public String getDiscountName() {
        return discountName;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", discountValue=" + discountValue +
                ", discountName='" + discountName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Discount other = (Discount) obj;
        return (this.discountValue == other.discountValue) &&
                (this.discountName == other.discountName);
    }

}
