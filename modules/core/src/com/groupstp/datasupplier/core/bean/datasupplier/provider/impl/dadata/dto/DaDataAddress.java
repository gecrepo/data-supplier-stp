package com.groupstp.datasupplier.core.bean.datasupplier.provider.impl.dadata.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/*
Название	Длина	Описание
source	250	Исходный адрес одной строкой
result	500	Стандартизованный адрес одной строкой
postal_code	6	Индекс
country	120	Страна
region_fias_id	36	Код ФИАС региона
region_kladr_id	19	Код КЛАДР региона
region_with_type	131	Регион с типом
region_type	10	Тип региона (сокращенный)
region_type_full	50	Тип региона
region	120	Регион
area_fias_id	36	Код ФИАС района в регионе
area_kladr_id	19	Код КЛАДР района в регионе
area_with_type	131	Район в регионе с типом
area_type	10	Тип района в регионе (сокращенный)
area_type_full	50	Тип района в регионе
area	120	Район в регионе
city_fias_id	36	Код ФИАС города
city_kladr_id	19	Код КЛАДР города
city_with_type	131	Город с типом
city_type	10	Тип города (сокращенный)
city_type_full	50	Тип города
city	120	Город
city_area	120	Административный округ (только для Москвы)
city_district_fias_id	36	Код ФИАС района города (заполняется, только если район есть в ФИАС)
city_district_kladr_id	19	Код КЛАДР района города (не заполняется)
city_district_with_type	131	Район города с типом
city_district_type	10	Тип района города (сокращенный)
city_district_type_full	50	Тип района города
city_district	120	Район города
settlement_fias_id	36	Код ФИАС нас. пункта
settlement_kladr_id	19	Код КЛАДР нас. пункта
settlement_with_type	131	Населенный пункт с типом
settlement_type	10	Тип населенного пункта (сокращенный)
settlement_type_full	50	Тип населенного пункта
settlement	120	Населенный пункт
street_fias_id	36	Код ФИАС улицы
street_kladr_id	19	Код КЛАДР улицы
street_with_type	131	Улица с типом
street_type	10	Тип улицы (сокращенный)
street_type_full	50	Тип улицы
street	120	Улица
house_fias_id	36	Код ФИАС дома
house_kladr_id	19	Код КЛАДР дома
house_type	10	Тип дома (сокращенный)
house_type_full	50	Тип дома
house	50	Дом
block_type	10	Тип корпуса/строения (сокращенный)
block_type_full	50	Тип корпуса/строения
block	50	Корпус/строение
flat_type	10	Тип квартиры (сокращенный)
flat_type_full	50	Тип квартиры
flat	50	Квартира
flat_area	50	Площадь квартиры
square_meter_price	50	Рыночная стоимость м²
flat_price	50	Рыночная стоимость квартиры
postal_box	50	Абонентский ящик
fias_id	36	Код ФИАС
HOUSE.HOUSEGUID — если дом найден в ФИАС по точному совпадению;
ADDROBJ.AOGUID — в противном случае;
fias_code		Иерархический код адреса в ФИАС (СС+РРР+ГГГ+ППП+СССС+УУУУ+ДДДД)
fias_level	2	Уровень детализации, до которого адрес найден в ФИАС
0 — страна;
1 — регион;
3 — район;
4 — город;
5 — район города;
6 — населенный пункт;
7 — улица;
8 — дом;
65 — планировочная структура;
90 — доп. территория;
91 — улица в доп. территории;
-1 — иностранный или пустой;
fias_actuality_state		Признак актуальности адреса в ФИАС
0 — актуальный;
1-50 — переименован;
51 — переподчинен;
99 — удален;
kladr_id	19	Код КЛАДР
capital_marker	1	Признак центра района или региона
1 — центр района (Московская обл, Одинцовский р-н, г Одинцово);
2 — центр региона (Новосибирская обл, г Новосибирск);
3 — центр района и региона (Томская обл, г Томск);
4 — центральный район региона (Тюменская обл, Тюменский р-н);
0 — ничего из перечисленного (Московская обл, г Балашиха);
okato	11	Код ОКАТО
oktmo	11	Код ОКТМО
tax_office	4	Код ИФНС для физических лиц
tax_office_legal	4	Код ИФНС для организаций
timezone	10	Часовой пояс
geo_lat	12	Координаты: широта
geo_lon	12	Координаты: долгота
beltway_hit	8	Внутри кольцевой?
IN_MKAD — внутри МКАД (Москва);
OUT_MKAD — за МКАД (Москва или Московская область);
IN_KAD — внутри КАД (Санкт-Петербург);
OUT_KAD — за КАД (Санкт-Петербург или Ленинградская область);
пусто — в остальных случаях;
beltway_distance	3	Расстояние от кольцевой в км.
Заполнено, только если beltway_hit = OUT_MKAD или OUT_KAD, иначе пустое
qc_geo	5	Код точности координат
qc_complete	5	Код пригодности к рассылке
qc_house	5	Признак наличия дома в ФИАС
qc	5	Код проверки адреса
unparsed_parts	250	Нераспознанная часть адреса.
Для адреса «Москва, Митинская улица, 40, вход с торца»
вернет «ВХОД, С, ТОРЦА»
metro		Список ближайших станций метро (до трёх штук)

DaDataAddress clean service response object example:
[
  {
    "source": "мск сухонска 11/-89",
    "result": "г Москва, ул Сухонская, д 11, кв 89",
    "postal_code": "127642",
    "country": "Россия",
    "region_fias_id": "0c5b2444-70a0-4932-980c-b4dc0d3f02b5",
    "region_kladr_id": "7700000000000",
    "region_with_type": "г Москва",
    "region_type": "г",
    "region_type_full": "город",
    "region": "Москва",
    "area_fias_id": null,
    "area_kladr_id": null,
    "area_with_type": null,
    "area_type": null,
    "area_type_full": null,
    "area": null,
    "city_fias_id": null,
    "city_kladr_id": null,
    "city_with_type": null,
    "city_type": null,
    "city_type_full": null,
    "city": null,
    "city_area": "Северо-восточный",
    "city_district_fias_id": null,
    "city_district_kladr_id": null,
    "city_district_with_type": "р-н Северное Медведково",
    "city_district_type": "р-н",
    "city_district_type_full": "район",
    "city_district": "Северное Медведково",
    "settlement_fias_id": null,
    "settlement_kladr_id": null,
    "settlement_with_type": null,
    "settlement_type": null,
    "settlement_type_full": null,
    "settlement": null,
    "street_fias_id": "95dbf7fb-0dd4-4a04-8100-4f6c847564b5",
    "street_kladr_id": "77000000000283600",
    "street_with_type": "ул Сухонская",
    "street_type": "ул",
    "street_type_full": "улица",
    "street": "Сухонская",
    "house_fias_id": "5ee84ac0-eb9a-4b42-b814-2f5f7c27c255",
    "house_kladr_id": "7700000000028360004",
    "house_type": "д",
    "house_type_full": "дом",
    "house": "11",
    "block_type": null,
    "block_type_full": null,
    "block": null,
    "flat_type": "кв",
    "flat_type_full": "квартира",
    "flat": "89",
    "flat_area": "34.6",
    "square_meter_price": "198113",
    "flat_price": "6854710",
    "postal_box": null,
    "fias_id": "5ee84ac0-eb9a-4b42-b814-2f5f7c27c255",
    "fias_code": "77000000000000028360004",
    "fias_level": "8",
    "fias_actuality_state": "0",
    "kladr_id": "7700000000028360004",
    "capital_marker": "0",
    "okato": "45280583000",
    "oktmo": "45362000",
    "tax_office": "7715",
    "tax_office_legal": "7715",
    "timezone": "UTC+3",
    "geo_lat": "55.8783675",
    "geo_lon": "37.6537388",
    "beltway_hit": "IN_MKAD",
    "beltway_distance": null,
    "qc_geo": 0,
    "qc_complete": 0,
    "qc_house": 2,
    "qc": 0,
    "unparsed_parts": null,
    "metro": [
        {
            "distance": 1.1,
            "line": "Калужско-Рижская",
            "name": "Бабушкинская"
        },
        {
            "distance": 1.2,
            "line": "Калужско-Рижская",
            "name": "Медведково"
        },
        {
            "distance": 2.5,
            "line": "Калужско-Рижская",
            "name": "Свиблово"
        }
    ]
  }
]
*/

/**
 * DaData service address representation class
 *
 * @author adiatullin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DaDataAddress implements Serializable {
    private static final long serialVersionUID = 6396135818000687548L;

    @JsonProperty("source")
    private String source;
    @JsonProperty("result")
    private String result;
    @JsonProperty("fias_id")
    private String fiasId;
    @JsonProperty("fias_code")
    private String fiasCode;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFiasId() {
        return fiasId;
    }

    public void setFiasId(String fiasId) {
        this.fiasId = fiasId;
    }

    public String getFiasCode() {
        return fiasCode;
    }

    public void setFiasCode(String fiasCode) {
        this.fiasCode = fiasCode;
    }
}
