/*J8003测试sql*/
select
    a.bond_code, a.issuer_name, a.bond_main_type, a.issuer_nature, a.issuer_rating, a.issuer_business, a.issuer_industry, a.edit_state
    from (select
		bond_code, 
		issuer_name, 
		'01' as bond_main_type, 
		issuer_nature, 
		issuer_rating, 
		issuer_business, 
		issuer_industry, 
		edit_state
		from bond_base_info where state=1 and edit_state=1
	union all
	select 
		b1.abs_code as bond_code, 
		b1.original_owner_name as issuer_name, 
		'02' as bond_main_type, 
		b1.nature as issuer_nature, 
		b1.main_rating as issuer_rating, 
		b1.business_scope as issuer_business, 
		b1.industry as issuer_industry, 
		b1.edit_state
		from abs_base_info b1 right join abs_issue_info a1 on a1.base_id=b1.id where a1.state=1) a where a.bond_code is not null and a.bond_code != ''

/*delete from bond_base_info where id=450*/
/*J8003测试重复sql*/
select a.bond_code,COUNT(a.bond_code)
from (select
		bond_code, 
		issuer_name, 
		'01' as bond_main_type, 
		issuer_nature, 
		issuer_rating, 
		issuer_business, 
		issuer_industry, 
		edit_state
		from bond_base_info where state=1 and edit_state=1
	union all
	select 
		b1.abs_code as bond_code, 
		b1.original_owner_name as issuer_name, 
		'02' as bond_main_type, 
		b1.nature as issuer_nature, 
		b1.main_rating as issuer_rating, 
		b1.business_scope as issuer_business, 
		b1.industry as issuer_industry, 
		b1.edit_state
		from abs_base_info b1 right join abs_issue_info a1 on a1.base_id=b1.id where a1.state=1) a 
where a.bond_code is not null and a.bond_code != '' GROUP BY a.bond_code HAVING COUNT(a.bond_code) > 1
