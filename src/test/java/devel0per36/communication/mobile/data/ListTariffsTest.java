package devel0per36.communication.mobile.data;

import devel0per36.communication.mobile.entity.*;
import devel0per36.communication.mobile.entity.component.Price;
import devel0per36.communication.mobile.entity.component.Quantity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import devel0per36.communication.mobile.entity.component.MediaService;
import devel0per36.communication.mobile.entity.component.Unlimited;

import java.util.ArrayList;
import java.util.List;

public class ListTariffsTest {
    private ListTariffs listTariffs;

    @BeforeEach
    public void init() {
        Price priceClassicTariff = new Price(1.80, 2.45, 8.0);
        Classic classicTariff = new Classic("Classic Tariff", 356, priceClassicTariff);
        Unlimited unlimitedStableTariff = new Unlimited(true);
        Enterprise stableTariff = new Enterprise("Stable Tariff", 1200, 578.78,
                unlimitedStableTariff);
        Quantity quantityOnlineTariff = new Quantity(50, 500, 50);
        Online onlineTariff = new Online("Online Tariff", 765, quantityOnlineTariff, true);
        Quantity quantitySuperTariff = new Quantity(50, 500, 50);
        List<MediaService> servicesSuperTariff = new ArrayList<>();
        servicesSuperTariff.add(MediaService.FRESH_SOUND);
        Social superTariff = new Social("Super Tariff", 878, quantitySuperTariff, true, servicesSuperTariff);

        List<Tariff> tariffs = new ArrayList<>();
        tariffs.add(classicTariff);
        tariffs.add(stableTariff);
        tariffs.add(onlineTariff);
        tariffs.add(superTariff);

        listTariffs = new ListTariffs(tariffs);
    }

    @Test
    @DisplayName("Попытка изменить элементы оригинального списка")
    public void tryChangeOriginalList() {
        List<Tariff> copy = listTariffs.getTariffs();
        Assertions.assertTrue(listTariffs.getTariffs().equals(copy));

        Price priceSimpleTariff = new Price(2, 2, 5);
        Classic simpleTariff = new Classic("Simple Tariff", 478, priceSimpleTariff);

        copy.add(simpleTariff);
        Assertions.assertFalse(listTariffs.getTariffs().equals(copy));
    }
}
