CREATE TABLE store (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(255) NOT NULL,
    img_url VARCHAR(2048) NOT NULL,
    link_url VARCHAR(2048) NOT NULL,
    tag VARCHAR(100) UNIQUE NOT NULL
);