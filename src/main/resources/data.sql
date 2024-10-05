INSERT INTO public.televisions (type, brand, name, price, available_size, refresh_rate, screen_type, screen_quality,
                                smart_tv, wifi, voice_control, hdr, bluetooth, ambi_light, original_stock, sold,
                                last_sold)
VALUES ('LED', 'Samsung', 'Series 7', 699.99, 'LARGE', 60, 'LED', 'Full HD', true, true, false, true, true, false,
        50, 10, '2024-01-15'),
       ('OLED', 'LG', 'C1', 1299.99, 'EXTRA_LARGE', 120, 'OLED', '4K UHD', true, true, true, true, true, true, 30, 5,
        '2024-03-10'),
       ('QLED', 'Sony', 'Bravia XR', 999.99, 'MEDIUM', 90, 'QLED', '4K UHD', true, true, true, true, false, true, 40,
        8, '2024-02-20');

INSERT INTO public.remote_controllers (compatible_with, battery_type, name, brand, price, original_stock)
VALUES ('Samsung', 'AA', 'Smart Remote', 'Samsung', 29.99, 100),
       ('LG', 'AAA', 'Magic Remote', 'LG', 39.99, 80),
       ('Sony', 'AA', 'Universal Remote', 'Sony', 24.99, 120);

INSERT INTO public.ci_modules(name, type, price)
VALUES ('ziggo', 'typetje', 29.99);

INSERT INTO public.wallbrackets(size, adjustable, name, price)
VALUES ('100x100', true, 'AOC', 99.99),
       ('75x75', false, 'samsung', 49.99),
       ('150x150', true, 'benco', 29.99);