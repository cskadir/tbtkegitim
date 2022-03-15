SELECT city, country FROM city
JOIN country ON city.country_id =country.country_id;


Select payment _id, first_name, last_name FROM customer
JOIN payment ON customer.customer_id = payment.customer_id

SELECT rental.rental_id, customer.first_name, customer.last_name FROM customer
INNER JOIN rental ON customer.customer_id=rental.customer_id;
