-- ================== MOVIES ==========================
INSERT INTO movieland.movies
(movie_id,
 name,
 name_original,
 year,
 country,
 description,
 rating,
 price,
 picture_path)
VALUES (1,
        'Побег из Шоушенка',
        'The Shawshank Redemption',
        '1994',
        'США',
        'Успешный банкир Энди Дюфрейн обвинен в убийстве собственной жены и ее любовника. Оказавшись в тюрьме под названием Шоушенк, он сталкивается с жестокостью и беззаконием, царящими по обе стороны решетки. Каждый, кто попадает в эти стены, становится их рабом до конца жизни. Но Энди, вооруженный живым умом и доброй душой, отказывается мириться с приговором судьбы и начинает разрабатывать невероятно дерзкий план своего освобождения.',
        8.90,
        123.45,
        'https://images-na.ssl-images-amazon.com/images/M/MV5BODU4MjU4NjIwNl5BMl5BanBnXkFtZTgwMDU2MjEyMDE@._V1._SY209_CR0,0,140,209_.jpg');
INSERT INTO movieland.movies
(movie_id,
 name,
 name_original,
 year,
 country,
 description,
 rating,
 price,
 picture_path)
VALUES (2,
        'Зеленая миля',
        'The Green Mile',
        '1999',
        'США',
        'Обвиненный в страшном преступлении, Джон Коффи оказывается в блоке смертников тюрьмы «Холодная гора». Вновь прибывший обладал поразительным ростом и был пугающе спокоен, что, впрочем, никак не влияло на отношение к нему начальника блока Пола Эджкомба, привыкшего исполнять приговор.',
        8.88,
        134.67,
        'https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BanBnXkFtZTYwOTU2NTY3._V1._SY209_CR0,0,140,209_.jpg');
INSERT INTO movieland.movies
(movie_id,
 name,
 name_original,
 year,
 country,
 description,
 rating,
 price,
 picture_path)
VALUES (3,
        'Форрест Гамп',
        'Forrest Gump',
        '1994',
        'США',
        'От лица главного героя Форреста Гампа, слабоумного безобидного человека с благородным и открытым сердцем, рассказывается история его необыкновенной жизни.Фантастическим образом превращается он в известного футболиста, героя войны, преуспевающего бизнесмена. Он становится миллиардером, но остается таким же бесхитростным, глупым и добрым. Форреста ждет постоянный успех во всем, а он любит девочку, с которой дружил в детстве, но взаимность приходит слишком поздно.',
        8.6,
        200.60,
        'https://images-na.ssl-images-amazon.com/images/M/MV5BMTUxMzQyNjA5MF5BMl5BaFgfdgfdnBnXkFtZTYwOTU2NTY3._V1._09_.jpg');

-- ================== GENRE ==========================
INSERT INTO movieland.genres
(genre_id,
 name)
VALUES (1,
        'драма');
INSERT INTO movieland.genres
(genre_id,
 name)
VALUES (2,
        'криминал');
INSERT INTO movieland.genres
(genre_id,
 name)
VALUES (3,
        'детектив');
INSERT INTO movieland.genres
(genre_id,
 name)
VALUES (4,
        'мелодрама');
INSERT INTO movieland.genres
(genre_id,
 name)
VALUES (5,
        'биография');
INSERT INTO movieland.genres
(genre_id,
 name)
VALUES (6,
        'комедия');

-- ================== MOVIE_GENRE ==========================
INSERT INTO movieland.movie_genre
(movie_id,
 genre_id)
VALUES (1,
        1);
INSERT INTO movieland.movie_genre
(movie_id,
 genre_id)
VALUES (1,
        4);
INSERT INTO movieland.movie_genre
(movie_id,
 genre_id)
VALUES (1,
        2);
INSERT INTO movieland.movie_genre
(movie_id,
 genre_id)
VALUES (2,
        5);
INSERT INTO movieland.movie_genre
(movie_id,
 genre_id)
VALUES (3,
        5);
INSERT INTO movieland.movie_genre
(movie_id,
 genre_id)
VALUES (3,
        4);

COMMIT;