# Zadanie rekrutacyjne DOZ

Do poprawnego działania aplikacji wymagana jest baza danych MySQL. Dane dostępowe należy wprowadzić w `/src/main/resources/application.properties`.
Aplikacja automatycznie wypełni bazę trzema przykładowymi produktami oraz pozycjami sprzedażowymi.

## Endpointy API:

### Wprowadzenie cenników

Request: `POST /api/update-prices`

```
[
    {
        "ean": "5909990880522",
        "price": 10.99
    },
    {
        "ean": "5909991308742",
        "price": 52.20
    }
]
```

Response: `204 No content`

### Pobieranie zestawienia sprzedaży

Request: `GET /api/sales-report/2024-03-04`

Response:
```
[
    {
        "id": 1,
        "product": {
            "id": 1,
            "name": "NO-SPA MAX Tabl. Powl.(80 MG) - 20 SZT.",
            "ean": "5909990880522",
            "price": 10.99
        },
        "date": "2024-03-04T15:50:00",
        "quantity": 1,
        "unitPrice": 13.99,
        "finalPrice": 13.99
    },
    [...]
]
```