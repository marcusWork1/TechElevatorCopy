-- 23. The name and date established of parks opened in the 1960s (6 rows)
select park_name, date_established
from park
where date_part('year', date_established) in(1960,1961,1962,1963,1964,1965,1966,1967,1968,1969)
;
