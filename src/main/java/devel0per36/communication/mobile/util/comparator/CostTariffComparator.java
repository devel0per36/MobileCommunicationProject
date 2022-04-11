package devel0per36.communication.mobile.util.comparator;

import devel0per36.communication.mobile.entity.Tariff;

import java.util.Comparator;

/**
 * Класс-компаратор сравнения объектов для сортировки тарифов на основе размера абонентской платы
 * @version 1.0
 */
public class CostTariffComparator implements Comparator<Tariff> {
    @Override
    public int compare(Tariff o1, Tariff o2) {
        return Double.compare(o1.findOutMonthlyCostOfTariff(), o2.findOutMonthlyCostOfTariff());
    }
}
