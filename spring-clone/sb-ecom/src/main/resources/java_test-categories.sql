-- 1. 테이블 삭제 (기존 테이블이 있을 경우)
DROP TABLE IF exists categories;

CREATE TABLE categories (
    category_id BIGSERIAL PRIMARY KEY,
    category_name VARCHAR(255) NOT NULL
);


INSERT INTO categories (category_name) VALUES 
('Electronics'), ('Smartphones'), ('Laptops & PCs'), ('Home Appliances'), 
('Kitchenware'), ('Furniture'), ('Office Supplies'), ('Books & Media'), 
('Video Games'), ('Musical Instruments'), ('Cameras & Photos'), ('Wearable Tech'), 
('Audio Devices'), ('Networking Gear'), ('Garden & Outdoor'), ('Automotive Parts'), 
('Pet Supplies'), ('Baby Products'), ('Beauty & Care'), ('Health & Wellness'), 
('Sports Equipment'), ('Outdoor Clothing'), ('Footwear Collection'), ('Fashion Accessories'), 
('Watch & Jewelry'), ('Travel & Luggage'), ('Art & Crafting'), ('Toys & Hobbies'), 
('Tools & Hardware'), ('Smart Home Devices');