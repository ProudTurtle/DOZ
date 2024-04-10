insert IGNORE into product (id, name, ean, price) values
    (1, "NO-SPA MAX Tabl. Powl.(80 MG) - 20 SZT.", "5909990880522", 13.99),
    (2, "APAP CAPS KAPS. MIĘKKIE(500 MG) - 10 SZT.", "5909991308742", 12.44),
    (3, "IBUPROM MAX TABL. DRAŻOWANE(400 MG) - 24 SZT.", "5909990970032", 6.99);

insert IGNORE into sale (id, product_id, date, quantity, unit_price) values
    (1, 1, "2024-03-04 15:50", 1, 13.99),
    (2, 2, "2024-03-04 13:20", 2, 12.44),
    (3, 1, "2024-03-05 15:20", 5, 13.99);